package com.unit11apps.videoplayer;

import com.unit11apps.Phonics3.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.VideoView;

public class VideoPlayerActivity extends Activity implements OnCompletionListener,OnPreparedListener,OnTouchListener {
            
    private VideoView mVV;
          
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
 
        setContentView(R.layout.videoplayer);
 
        Uri uri = null;    
        Bundle e = getIntent().getExtras();
        if (e!=null) {
        	uri = (Uri)(e.get("uri"));
        }
 
        mVV = (VideoView)findViewById(R.id.myvideoview);
        mVV.setOnCompletionListener(this);
        mVV.setOnPreparedListener(this);
        mVV.setOnTouchListener(this);
 
        if(uri.toString().length() > 0)
        {
        	mVV.setVideoURI(uri);
        	mVV.start();
        }
        else
        {
        	finish();
        }
    }
 
    public void stopPlaying() {
        mVV.stopPlayback();
        this.finish();             
    }
 
    @Override
    public void onCompletion(MediaPlayer mp) {
        finish();
    }
             
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        stopPlaying();
        return true;
    }
 
    @Override
    public void onPrepared(MediaPlayer mp) {
    }
}