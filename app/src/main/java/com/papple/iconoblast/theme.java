package com.papple.iconoblast;import android.content.SharedPreferences;import android.os.Build;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.support.v7.widget.Toolbar;import android.view.Gravity;import android.view.View;import android.widget.Button;import android.widget.RadioButton;import android.widget.TextView;import android.widget.Toast;import android.content.Intent;import com.github.javiersantos.appupdater.AppUpdater;import com.github.javiersantos.appupdater.enums.Display;import com.github.javiersantos.appupdater.enums.UpdateFrom;import com.jaeger.library.StatusBarUtil;import static maes.tech.intentanim.CustomIntent.customType;public class theme extends AppCompatActivity {    @Override    public void onCreate(Bundle savedInstanceState) {        final SharedPreferences settings = getSharedPreferences("Answers", 0);        boolean answerA = settings.getBoolean("questionA", false);        boolean answerB = settings.getBoolean("questionB", false);        boolean answerC = settings.getBoolean("questionC", false);        boolean answerD = settings.getBoolean("questionD", false);        boolean autoMajBoolean = settings.getBoolean("automaj", false);        if (answerA) {            setTheme(R.style.AppTheme_NoActionBar);        } else if (answerB) {            setTheme(R.style.DarkTheme);        } else {            setTheme(R.style.AppTheme_NoActionBar);        }        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_theme);        Toolbar toolbar2 = findViewById(R.id.toolbar2);        setSupportActionBar(toolbar2);        if (getSupportActionBar() != null) {            getSupportActionBar().setDisplayHomeAsUpEnabled(true);        }        RadioButton radio1 = findViewById(R.id.radiobox_1);        RadioButton radio2 = findViewById(R.id.radiobox_2);        RadioButton radio3 = findViewById(R.id.radiobox_3);        RadioButton radio4 = findViewById(R.id.radiobox_4);        RadioButton radio5 = findViewById(R.id.radiobox_5);        RadioButton radio6 = findViewById(R.id.radiobox_6);        if (answerA) {            radio1.setChecked(true);        } else if (answerB) {            radio2.setChecked(true);        } else {            radio1.setChecked(true);        }        if (answerC) {            radio3.setChecked(true);        } else if (answerD) {            radio4.setChecked(true);        } else {            radio3.setChecked(true);        }        if (autoMajBoolean) {            radio5.setChecked(true);        } else {            radio6.setChecked(true);        }        Button majButton = findViewById(R.id.majButton);        majButton.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Toast.makeText(theme.this, "Recherche de Mise à Jour...", Toast.LENGTH_SHORT).show();                new AppUpdater(theme.this)                        .setUpdateFrom(UpdateFrom.GITHUB)                        .setGitHubUserAndRepo("Tintin361", "iconoblast_soundbox")                        .setTitleOnUpdateNotAvailable("Aucune nouvelle Mise à Jour !")                        .setContentOnUpdateNotAvailable("Aucune MàJ disponible, vérifiez plus tard !\n")                        .setIcon(R.drawable.ic_update_black)                        .setButtonDoNotShowAgain(null)                        .showAppUpdated(true)                        .setButtonDismiss("Plus tard")                        .setDisplay(Display.DIALOG)                        .start();            }        });    }    public boolean onSupportNavigateUp() {        onBackPressed();        customType(this, "right-to-left");        return true;    }    @Override    public void onBackPressed() {        super.onBackPressed();        customType(this, "right-to-left");    }    public void onClick(View v) {        SharedPreferences settings = getSharedPreferences("Answers", 0);        SharedPreferences.Editor editor = settings.edit();        RadioButton radio1 = findViewById(R.id.radiobox_1);        RadioButton radio2 = findViewById(R.id.radiobox_2);        editor.putBoolean("questionA", radio1.isChecked());        editor.putBoolean("questionB", radio2.isChecked());        editor.apply();        if (radio1.isChecked()) {            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));            startActivity(new Intent(this, theme.class));            customType(this, "fadein-to-fadeout");            Toast toaster = Toast.makeText(theme.this, "Le thème de base est activé.", Toast.LENGTH_SHORT);            TextView view = toaster.getView().findViewById(android.R.id.message);            if (view != null) view.setGravity(Gravity.CENTER);            toaster.show();        } else if (radio2.isChecked()) {            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));            startActivity(new Intent(this, theme.class));            customType(this, "fadein-to-fadeout");            Toast toaster2 = Toast.makeText(theme.this, "Le thème sombre est activé.", Toast.LENGTH_SHORT);            TextView view2 = toaster2.getView().findViewById(android.R.id.message);            if (view2 != null) view2.setGravity(Gravity.CENTER);            toaster2.show();        }        super.recreate();    }    public void onShowClick(View v) {        SharedPreferences settings = getSharedPreferences("Answers", 0);        SharedPreferences.Editor editor = settings.edit();        RadioButton radio3 = findViewById(R.id.radiobox_3);        RadioButton radio4 = findViewById(R.id.radiobox_4);        editor.putBoolean("questionC", radio3.isChecked());        editor.putBoolean("questionD", radio4.isChecked());        editor.apply();        if (radio3.isChecked()) {            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));            startActivity(new Intent(this, theme.class));            customType(this, "left-to-right");            Toast toaster3 = Toast.makeText(theme.this, "L'affichage des sons est en liste.", Toast.LENGTH_SHORT);            TextView view3 = toaster3.getView().findViewById(android.R.id.message);            if (view3 != null) view3.setGravity(Gravity.CENTER);            toaster3.show();        } else if (radio4.isChecked()) {            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));            startActivity(new Intent(this, theme.class));            customType(this, "left-to-right");            Toast toaster4 = Toast.makeText(theme.this, "L'affichage des sons est en grille.\n" + "Il ne fonctionne que sur les sons DDLC et Deltarune.", Toast.LENGTH_LONG);            TextView view4 = toaster4.getView().findViewById(android.R.id.message);            if (view4 != null) view4.setGravity(Gravity.CENTER);            toaster4.show();        }    }    public void onCheckboxClick(View v) {        final SharedPreferences settings = getSharedPreferences("Answers", 0);        final SharedPreferences.Editor editor = settings.edit();        RadioButton radio5 = findViewById(R.id.radiobox_5);        RadioButton radio6 = findViewById(R.id.radiobox_6);        if (radio5.isChecked()) {            editor.putBoolean("automaj", true).apply();            Toast.makeText(theme.this, "Cette option consomme un petite quantitée de données (environ 16 ko).", Toast.LENGTH_SHORT).show();        } else if (radio6.isChecked()) {            editor.putBoolean("automaj", false).apply();        }    }}