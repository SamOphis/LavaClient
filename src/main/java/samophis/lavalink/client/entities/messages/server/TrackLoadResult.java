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

package samophis.lavalink.client.entities.messages.server;

@SuppressWarnings({"WeakerAccess", "unused"})
public class TrackLoadResult {
    public String playlistName;
    public Integer selectedTrack;
    public TrackLoadResultObject[] tracks;
    public boolean isPlaylist;
    public class TrackLoadResultObject {
        public String track;
        public TrackLoadResultObjectInfo info;
    }
    public class TrackLoadResultObjectInfo {
        public String identifier, title, author, uri;
        public boolean isSeekable, isStream;
        public long position, length;
    }
}