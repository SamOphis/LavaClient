/*
   Copyright 2018 Samuel Pritchard

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

package samophis.lavalink.client.entities;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents an entry for an {@link AudioNode AudioNode} with configuration options.
 * This class can be constructed with an {@link samophis.lavalink.client.entities.builders.AudioNodeEntryBuilder AudioNodeEntryBuilder}.
 *
 * @since 0.1
 * @author SamOphis
 */

public interface AudioNodeEntry {
    /**
     * Fetches the {@link LavaClient LavaClient} instance associated with this entry.
     * <br><p>Note: This entry gets its default values from the client.</p>
     * @return The {@link LavaClient LavaClient} instance from which the entry gets its default values.
     */
    @Nonnull
    LavaClient getClient();

    /**
     * Fetches the server address of the {@link AudioNode AudioNode} this entry represents,
     * as provided by the user through an {@link samophis.lavalink.client.entities.builders.AudioNodeEntryBuilder AudioNodeEntryBuilder}.
     * @return The raw server address of the {@link AudioNode AudioNode} this entry represents.
     */
    @Nonnull
    String getRawAddress();

    /**
     * Fetches the HTTP address of the {@link AudioNode AudioNode} this entry represents, as used by the {@link LavaHttpManager LavaHttpManager} class.
     * @return The HTTP address of the {@link AudioNode AudioNode} this entry represents, with a default {@code 'http://'} scheme if not already provided.
     */
    @Nonnull
    String getHttpAddress();

    /**
     * Fetches the WebSocket address (with the {@code 'ws://'} scheme) of the {@link AudioNode AudioNode} this entry represents.
     * <br><p>This value cannot be specified manually -- it is constructed from the original server address passed to LavaClient.</p>
     * @return The WebSocket address of the {@link AudioNode AudioNode} this entry represents.
     */
    @Nonnull
    String getWebSocketAddress();

    /**
     * Fetches the password of the associated {@link AudioNode AudioNode}.
     * <br><p>The password of this entry will be replaced with the default password if one isn't specified during construction of this entry.</p>
     * @return The password of the {@link AudioNode AudioNode} this entry represents.
     */
    @Nonnull
    String getPassword();

    /**
     * Fetches the WebSocket port of the associated {@link AudioNode AudioNode}.
     * <br><p>The WebSocket port of this entry will be replaced with the default WebSocket port if one isn't specified during construction of this entry.</p>
     * @return The WebSocket port of the {@link AudioNode AudioNode} this entry represents.
     */
    @Nonnegative
    int getWebSocketPort();

    /**
     * Fetches the REST API port of the associated {@link AudioNode AudioNode}.
     * <br><p>The REST API port of this entry will be replaced with the default REST API port if one isn't specified during construction of this entry.</p>
     * @return The REST API port of the {@link AudioNode AudioNode} this entry represents.
     */
    @Nonnegative
    int getRestPort();

    /**
     * Returns whether or not the {@link AudioNode AudioNode} this entry represents is running Lavalink Server v3.
     * <br><p>If this value is true, any {@link AudioWrapper AudioWrapper} returned from loading tracks will be missing everything besides the track list.
     * <br>Deprecated since v1.2 as the newest versions of Lavalink v3 report their version server-side.</p>
     * @return Whether or not this node is running Lavalink Server v3.
     */
    @Deprecated
    boolean isUsingLavalinkVersionThree();

    /**
     * Fetches the <b>possibly-null</b> {@link SocketInitializer SocketInitializer} used to "initialize" a LavaClient WebSocket connection.
     * @return The <b>possibly-null</b> {@link SocketInitializer SocketInitializer} attached to this node entry.
     */
    @Nullable SocketInitializer getSocketInitializer();
}