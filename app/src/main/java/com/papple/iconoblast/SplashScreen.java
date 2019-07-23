package com.papple.iconoblast;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.app.Activity;
import android.widget.RelativeLayout;

import static maes.tech.intentanim.CustomIntent.customType;

public class SplashScreen extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RelativeLayout rLayout = findViewById(R.id.relativeLayoutSplash);
            rLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        int SPLASH_TIME_OUT = 300;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    customType(SplashScreen.this,"bottom-to-up");
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
