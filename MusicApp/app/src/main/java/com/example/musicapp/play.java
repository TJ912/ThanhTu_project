package com.example.musicapp;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.renderscript.ScriptIntrinsic;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


import com.jgabrielfreitas.core.BlurImageView;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class play extends AppCompatActivity implements View.OnClickListener {
    Button pause, next, previous;
    SeekBar seekBar;
    TextView timepass, timeleft, song;
    ImageView imageView;
    ArrayList<Song> songs = new ArrayList<>();
    Data data = new Data();
    MediaPlayer music;
    Integer position;
    Boolean flag;
    Timer timer;
    RunTimer runTimer;
    String link;
    BlurImageView blurImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setContentView(R.layout.activity_play);


        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("status","destroy");
    }


    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void init() {
        pause = findViewById(R.id.btn_pause);
        next = findViewById(R.id.btn_next);
        previous = findViewById(R.id.btn_previous);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        timepass = findViewById(R.id.tv_timerun);
        timeleft = findViewById(R.id.tv_timeleft);
        song = findViewById(R.id.tv_song);
        blurImageView=findViewById(R.id.blurimageview);
        flag = false;
        pause.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

        Collections.addAll(songs, data.songs);
        rotateDisc();
        Bundle bundle = getIntent().getExtras();


        //Nhận data
        if (bundle != null) {
            position = bundle.getInt("id");
        }
        xuly();
        rotateDisc();

    }


    public void xuly() {
        if (flag) {
            music.stop();
            timer.cancel();
        }

        Log.d("vitri", String.valueOf(position));
        link = songs.get(position).getMusic();
        song.setText(songs.get(position).getSinger() + " - " + songs.get(position).getName());
        imageView.setImageResource(songs.get(position).getPicture());
        pause.setBackgroundResource(R.drawable.outline_pause_black_24dp);

        getSong(link);

        flag = true;


    }

    public class RunTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(() -> {
                seekBar.incrementProgressBy(1);
                convertTime(timepass, seekBar.getProgress());
                if (seekBar.getProgress() == seekBar.getMax()) {
                    nextSong();

                }

            });
        }
    }

    public void nextSong() {
        if (position == songs.size() - 1)
            position = 0;
        else
            position = position + 1;

        xuly();

    }

    public void getSong(String link) {

        music = MediaPlayer.create(play.this, Uri.parse(link));
        music.setOnPreparedListener(mp -> {
            if(music.isPlaying()){
                music.stop();
                music.release();
            }
            else {
                music.start();
                int timeDuration = music.getDuration();
                convertTime(timeleft, timeDuration);
                seekBar.setMax(timeDuration);
                seekBar.setProgress(0);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        music.seekTo(seekBar.getProgress());
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        music.seekTo(seekBar.getProgress());
                    }
                });
                runTimer = new RunTimer();
                timer = new Timer();
                timer.scheduleAtFixedRate(runTimer, 0, 1);
            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (position == songs.size() - 1)
                    position = 0;
                else
                    position = position + 1;

                xuly();
                break;
            case R.id.btn_pause:
                if (flag) {
                    flag = false;
                    music.pause();
                    pause.setBackgroundResource(R.drawable.outline_play_circle_outline_black_24dp);
                    runTimer.cancel();


                } else {
                    pause.setBackgroundResource(R.drawable.outline_pause_black_24dp);
                    music.start();
                    runTimer = new RunTimer();
                    timer.scheduleAtFixedRate(runTimer, 0, 1);
                    flag = true;

                }

                break;
            case R.id.btn_previous:
                if (position == 0)
                    position = songs.size() - 1;
                else
                    position = position - 1;

                xuly();
                break;

        }
    }

    public void convertTime(TextView tv, int time) {
        NumberFormat f = new DecimalFormat("00");
        long timeMinutes = TimeUnit.MILLISECONDS.toMinutes((long) time);
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(timeMinutes);
        String result = f.format(timeMinutes) + ":" + f.format((timeSeconds));
        tv.setText(result);
    }

    public void rotateDisc() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator()); //gan hieu ung
        rotateAnimation.setDuration(8000);
        imageView.startAnimation(rotateAnimation);


    }
}
