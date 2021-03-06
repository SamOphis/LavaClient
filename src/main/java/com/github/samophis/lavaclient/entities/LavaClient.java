/*
   Copyright 2019 Sam Pritchard

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.github.samophis.lavaclient.entities;

import com.github.samophis.lavaclient.entities.internal.LavaClientImpl;
import gnu.trove.map.hash.TLongObjectHashMap;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public interface LavaClient {
	@Nonnull
	@CheckReturnValue
	Vertx vertx();

    @Nonnull
    @CheckReturnValue
    List<AudioNode> nodes();

    @Nonnull
	@CheckReturnValue
	List<LavaPlayer> players();

    @Nullable
    @CheckReturnValue
    AudioNode node(@Nonnull final String baseUrl);

    @Nonnull
    @CheckReturnValue
    AudioNode bestNode();

    @Nullable
	@CheckReturnValue
	LavaPlayer player(@Nonnegative final long guildId);

    @Nonnull
	@CheckReturnValue
	LavaPlayer newPlayer(@Nonnegative final long guildId);

    @Nonnull
	LavaPlayer removePlayer(@Nonnegative final long guildId, final boolean shouldDestroy);

    @CheckReturnValue
	@Nonnull
	AudioNode nodeFrom(@Nonnull final AudioNodeOptions options);

	@Nonnegative
	@CheckReturnValue
	long userId();

	@Nonnegative
	@CheckReturnValue
	int numShards();

	void addNode(@Nonnull final AudioNode node);

	void removeNode(@Nonnull final String baseUrl);

	void shutdown();

	default void removeNode(@Nonnull final AudioNode node) {
		removeNode(node.baseUrl());
	}

	@Nonnull
	default LavaPlayer removePlayer(@Nonnegative final long guildId) {
		return removePlayer(guildId, true);
	}

	@CheckReturnValue
	@Nonnull
	static LavaClient from(@Nonnull final LavaClientOptions options) {
		final var vertxOptions = options.vertxOptions() == null
				? new VertxOptions()
				: options.vertxOptions();
		final var userId = options.userId();
		if (userId <= 0) {
			throw new IllegalArgumentException("user id cannot be smaller than or equal to 0");
		}
		final var shardCount = options.shardCount();
		if (shardCount <= 0) {
			throw new IllegalArgumentException("shard count cannot be smaller than or equal to 0");
		}
		return new LavaClientImpl(Vertx.vertx(vertxOptions), new ArrayList<>(), new TLongObjectHashMap<>(), userId,
				shardCount);
	}
}
