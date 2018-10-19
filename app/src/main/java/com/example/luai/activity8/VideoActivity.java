package com.example.luai.activity8;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoActivity extends AppCompatActivity {

    private SimpleExoPlayer mExoPlayer;
    private SimpleExoPlayerView mExoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // TODO (3): Find the SimpleExoPlayerView view

        String videoUrl = getString(R.string.url1);

        Intent i = getIntent();
        if (i != null) {
            switch (i.getIntExtra("index", 0)) {
                case 0:
                    videoUrl = getString(R.string.url1);
                    break;
                case 1:
                    videoUrl = getString(R.string.url2);
                    break;
                case 2:
                    videoUrl = getString(R.string.url3);
                    break;
                default:
                    videoUrl = getString(R.string.url1);
            }
        }

        long position;
        // TODO (6): Use the saved instance state to get the position of stored exo player position. If there is no instance state, just set it to 0



        initializePlayer(Uri.parse(videoUrl), position);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // TODO (5): Put the position of the exo player to outState using getCurrentPosition
        outState.putLong("video-position", mExoPlayer.getCurrentPosition());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO (8): Release the player
    }

    private void initializePlayer(Uri mediaUri, long position) {

        if (mExoPlayer == null) {

            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();


            mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);

            // TODO (4): Make the player go to the passed in position using seekTo

            mExoPlayerView.setPlayer(mExoPlayer);


            String userAgent = Util.getUserAgent(this, "SessionActivity");
            MediaSource mediaSource = new ExtractorMediaSource(
                    mediaUri,
                    new DefaultDataSourceFactory(this, userAgent),
                    new DefaultExtractorsFactory(), null, null);

            mExoPlayer.prepare(mediaSource);

            mExoPlayer.setPlayWhenReady(false);

        }

    }

    private void releasePlayer() {

        // TODO (7): If mExoPlayer is not null, stop it, release it and then set it to null

    }

}
