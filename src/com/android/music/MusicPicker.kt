/*
 * Copyright (C) 2019 The Android Open Source Project
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
package com.android.music

import android.app.ListActivity
import android.content.AsyncQueryHandler
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.database.CharArrayBuffer
import android.database.Cursor
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioButton
import android.widget.SectionIndexer
import android.widget.SimpleCursorAdapter
import android.widget.TextView

/**
 * A dummy class to handle android.intent.action.PICK Intent.
 */
class MusicPicker : ListActivity(), View.OnClickListener {
    /** Uri to the directory of all music being displayed.  */
    var mBaseUri: Uri? = null

    /** Called when the activity is first created.  */
    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        mBaseUri = if (Intent.ACTION_GET_CONTENT.equals(getIntent().getAction())) {
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        } else {
            getIntent().getData()
        }
        Log.w("MusicPicker", "Doesn't handle for data URI given to PICK action")
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        return true
    }

    protected override fun onSaveInstanceState(icicle: Bundle) {
        super.onSaveInstanceState(icicle)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    protected override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {}

    override fun onClick(v: View?) {}

    companion object {
        const val DBG = false
        const val TAG = "MusicPicker"
    }
}