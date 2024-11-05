package com.robinbd.exam.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.R;

public class SplashScreen extends AppCompatActivity {
    TextView tex1;
    Animation zoomin,myanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        tex1 =findViewById(R.id.tex1);

        zoomin = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.zoom_in);

        tex1.startAnimation(zoomin);


        MediaPlayer myplayer = MediaPlayer.create(SplashScreen.this,R.raw.bismillah_ir_rahman);
        myplayer.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myint = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(myint);

            }
        },6*1000);




    }
}