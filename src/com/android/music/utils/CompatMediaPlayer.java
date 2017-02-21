/*
 * Copyright (C) 2017 The Android Open Source Project
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
package com.android.music.utils;

import android.media.MediaPlayer;
import android.os.SystemClock;

public class CompatMediaPlayer extends MediaPlayer implements MediaPlayer.OnCompletionListener {
    private boolean mCompatMode = true;
    private MediaPlayer mNextPlayer;
    private OnCompletionListener mCompletion;

    public CompatMediaPlayer() {
        try {
            MediaPlayer.class.getMethod("setNextMediaPlayer", MediaPlayer.class);
            mCompatMode = false;
        } catch (NoSuchMethodException e) {
            mCompatMode = true;
            super.setOnCompletionListener(this);
        }
    }

    public void setNextMediaPlayer(MediaPlayer next) {
        if (mCompatMode) {
            mNextPlayer = next;
        } else {
            super.setNextMediaPlayer(next);
        }
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        if (mCompatMode) {
            mCompletion = listener;
        } else {
            super.setOnCompletionListener(listener);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (mNextPlayer != null) {
            // as it turns out, starting a new MediaPlayer on the completion
            // of a previous player ends up slightly overlapping the two
            // playbacks, so slightly delaying the start of the next player
            // gives a better user experience
            SystemClock.sleep(50);
            mNextPlayer.start();
        }
        mCompletion.onCompletion(this);
    }
}