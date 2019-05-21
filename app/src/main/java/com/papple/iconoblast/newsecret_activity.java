package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class newsecret_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar);
        } else if (answerB) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
    }

}
