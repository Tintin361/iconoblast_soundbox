package com.papple.iconoblast;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;

import static maes.tech.intentanim.CustomIntent.customType;

public class SplashScreen extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RelativeLayout rLayout = findViewById(R.id.relativeLayoutSplash);
            rLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark));

            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
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
