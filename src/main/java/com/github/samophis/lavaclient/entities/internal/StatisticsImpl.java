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
package com.github.samophis.lavaclient.entities.internal;

import com.github.samophis.lavaclient.entities.Statistics;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(fluent = true)
public class StatisticsImpl implements Statistics {
	private int players, playingPlayers, cpuCores;
	private long uptime, freeMemory, allocatedMemory, usedMemory, reservableMemory;
	private double systemLoad, lavalinkLoad;
	private Long sentFrames, nulledFrames, deficitFrames;
}
