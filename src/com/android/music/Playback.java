/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

import static android.media.MediaPlayer.OnCompletionListener;
import static android.media.MediaPlayer.OnErrorListener;
import static android.media.MediaPlayer.OnPreparedListener;
import static android.media.MediaPlayer.OnSeekCompleteListener;
import static android.media.session.MediaSession.QueueItem;

/**
 * A class that implements local media playback using {@link android.media.MediaPlayer}
 */
public class Playback implements AudioManager.OnAudioFocusChangeListener, OnCompletionListener,
                                 OnErrorListener, OnPreparedListener, OnSeekCompleteListener {
    public Playback() {}

    public void start() {}

    public void setState(int state) {}

    public void setCallback(Callback callback) {}

    @Override
    public void onAudioFocusChange(int focusChange) {}

    @Override
    public void onSeekComplete(MediaPlayer mp) {}

    @Override
    public void onCompletion(MediaPlayer player) {}

    @Override
    public void onPrepared(MediaPlayer player) {}

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return true; // true indicates we handled the error
    }

    public interface Callback {
        /**
         * @param error to be added to the PlaybackState
         */
        void onError(String error);
    }
}
