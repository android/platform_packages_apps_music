/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.music;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Allows {@link MediaPlayerHolder} to report media playback duration and progress updates to
 * the {@link MainActivity}.
 */
public abstract class PlaybackInfoListener {

    @IntDef({State.INVALID, State.PLAYING, State.PAUSED, State.RESET, State.COMPLETED})
    @Retention(RetentionPolicy.SOURCE)
    @interface State {

        int INVALID = -1;
        int PLAYING = 0;
        int PAUSED = 1;
        int RESET = 2;
        int COMPLETED = 3;
    }

    public static String convertStateToString(@State int state) {
        String stateString;
        switch (state) {
            case State.COMPLETED:
                stateString = "COMPLETED";
                break;
            case State.INVALID:
                stateString = "INVALID";
                break;
            case State.PAUSED:
                stateString = "PAUSED";
                break;
            case State.PLAYING:
                stateString = "PLAYING";
                break;
            case State.RESET:
                stateString = "RESET";
                break;
            default:
                stateString = "N/A";
        }
        return stateString;
    }

    void onLogUpdated(String formattedMessage) {
    }

    void onDurationChanged(int duration) {
    }

    void onPositionChanged(int position) {
    }

    void onStateChanged(@State int state) {
    }

    void onPlaybackCompleted() {
    }
}
