package com.example.netflix_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    // Set Duration of Screen
    private final int SPLASH_DISPLAY_DURATION = 2000; // 3 sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_DURATION);




    }
}