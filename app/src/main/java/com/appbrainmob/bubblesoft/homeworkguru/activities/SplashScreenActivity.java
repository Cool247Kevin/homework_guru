package com.appbrainmob.bubblesoft.homeworkguru.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.appbrainmob.bubblesoft.homeworkguru.R;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final int delayTime = 5000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
            }
        }, delayTime);
    }
}
