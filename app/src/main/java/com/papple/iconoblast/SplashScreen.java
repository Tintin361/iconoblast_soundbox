package com.papple.iconoblast;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.app.Activity;

public class SplashScreen extends Activity{

    private static int SPLASH_TIME_OUT = 300;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
