package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class theme extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences settings = getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar2);
        } else if (answerB) {
            setTheme(R.style.DarkTheme);
        } else if (answerC) {
            setTheme(R.style.AppTheme_Green);
        } else {
            setTheme(R.style.AppTheme_NoActionBar2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RadioButton radio1 = findViewById(R.id.radiobox_1);
        RadioButton radio2 = findViewById(R.id.radiobox_2);
        RadioButton radio3 = findViewById(R.id.radiobox_3);

        if (answerA) {
            radio1.setChecked(true);
        } else if (answerB) {
            radio2.setChecked(true);
        } else if (answerC) {
            radio3.setChecked(true);
        } else {
            radio1.setChecked(true);
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onClick(View v) {

        SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        RadioButton radio1 = findViewById(R.id.radiobox_1);
        RadioButton radio2 = findViewById(R.id.radiobox_2);
        RadioButton radio3 = findViewById(R.id.radiobox_3);

        editor.putBoolean("questionA", radio1.isChecked());
        editor.putBoolean("questionB", radio2.isChecked());
        editor.putBoolean("questionC", radio3.isChecked());

        editor.apply();

        if (radio1.isChecked()) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            startActivity(new Intent(this, theme.class));

            Toast toaster = Toast.makeText(theme.this, "Le thème de base est activé.", Toast.LENGTH_SHORT);
            TextView view = toaster.getView().findViewById(android.R.id.message);
            if (view != null) view.setGravity(Gravity.CENTER);
            toaster.show();
        } else if (radio2.isChecked()) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            startActivity(new Intent(this, theme.class));

            Toast toaster2 = Toast.makeText(theme.this, "Le thème sombre est activé.", Toast.LENGTH_SHORT);
            TextView view2 = toaster2.getView().findViewById(android.R.id.message);
            if (view2 != null) view2.setGravity(Gravity.CENTER);
            toaster2.show();
        } else if (radio3.isChecked()) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            startActivity(new Intent(this, theme.class));

            Toast toaster3 = Toast.makeText(theme.this, "Le thème Vert est activé.", Toast.LENGTH_SHORT);
            TextView view3 = toaster3.getView().findViewById(android.R.id.message);
            if (view3 != null) view3.setGravity(Gravity.CENTER);
            toaster3.show();
        }

        super.recreate();

    }

}
