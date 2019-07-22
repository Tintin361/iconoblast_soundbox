package com.papple.iconoblast;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.app.Activity;
import static maes.tech.intentanim.CustomIntent.customType;

public class SplashScreen extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 300;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                customType(SplashScreen.this,"up-to-bottom");
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
