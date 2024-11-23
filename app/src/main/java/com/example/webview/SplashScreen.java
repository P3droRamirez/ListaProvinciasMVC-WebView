package com.example.webview;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(mainIntent);
            finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,3000);
    }
}