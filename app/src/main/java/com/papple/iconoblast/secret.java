package com.papple.iconoblast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import com.jaeger.library.StatusBarUtil;

import static maes.tech.intentanim.CustomIntent.customType;

public class secret extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        final SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        final boolean answerA = settings.getBoolean("questionA", false);
        final boolean answerB = settings.getBoolean("questionB", false);
        final boolean lenvers = settings.getBoolean("lenvers", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar);
        } else if (answerB) {
            setTheme(R.style.DarkTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);

        final Toolbar toolbar3 = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (answerA) {
            toolbar3.setBackgroundResource(R.drawable.rounded_toolbar);
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white));
        } else if (answerB) {
            toolbar3.setBackgroundResource(R.drawable.rounded_toolbar_dark);
            StatusBarUtil.setColor(this, getResources().getColor(R.color.dddlc));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerA) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, android.R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerB) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.dddlc));
        }

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.checkButton);
        final ScrollView scrollView = findViewById(R.id.secretLayout);

        SharedPreferences prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        String editTextvalue = prefs.getString("VALUE", "");
        editText.setText(editTextvalue);

        button.setOnClickListener(v -> {
            ImageView imageView = findViewById(R.id.imageView);

            if (editText.getText().toString().equals("666")) {

                Toast.makeText(secret.this, "" + ("\ud83d\udd25"), Toast.LENGTH_SHORT).show();

            } else if (editText.getText().toString().isEmpty()) {

                Toast toaster2 = Toast.makeText(secret.this, "Merci de bien vouloir entrer un code secret.", Toast.LENGTH_SHORT);
                TextView view2 = toaster2.getView().findViewById(android.R.id.message);
                if (view2 != null) view2.setGravity(Gravity.CENTER);
                toaster2.show();

            } else if (editText.getText().toString().equals("Hentai")) {

                Toast.makeText(secret.this, "" + ("\ud83d\ude0f"), Toast.LENGTH_SHORT).show();

            } else if (editText.getText().toString().equals("Windows")) {

                // Retour au l'écran d'acceuil...
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

                // Le Toast
                Toast toast3 = Toast.makeText(secret.this, "Désolé, l'application doit se mettre à jour... " + ("\uD83D\uDE02"), Toast.LENGTH_SHORT);
                TextView view3 = toast3.getView().findViewById(android.R.id.message);
                if (view3 != null) view3.setGravity(Gravity.CENTER);
                toast3.show();

            } else if (editText.getText().toString().equals("Claude")) {

                if (lenvers) {
                    editor.putBoolean("lenvers", false);
                    editor.apply();

                    Toast toaster6 = Toast.makeText(secret.this, "Claude", Toast.LENGTH_SHORT);
                    TextView view6 = toaster6.getView().findViewById(android.R.id.message);
                    if (view6 != null) view6.setGravity(Gravity.CENTER);
                    toaster6.show();
                } else {
                    editor.putBoolean("lenvers", true);
                    editor.apply();

                    Toast toast4 = Toast.makeText(secret.this, "ǝpnɐlɔ", Toast.LENGTH_SHORT);
                    TextView view4 = toast4.getView().findViewById(android.R.id.message);
                    if (view4 != null) view4.setGravity(Gravity.CENTER);
                    toast4.show();
                }

                startActivity(new Intent(secret.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                startActivity(new Intent(secret.this, theme.class));
                startActivity(new Intent(secret.this, secret.class));
                Animatoo.animateZoom(this);

            } else if (editText.getText().toString().equals("Tiki")) {

                imageView.setBackgroundResource(R.drawable.faketiki);

            } else if (editText.getText().toString().equals("Marc-André") || editText.getText().toString().equals("Pigeon")) {

                imageView.setBackgroundResource(R.drawable.smic);

            } else if (!editText.getText().toString().equals("K/DA - POP/STARS")) {

                Toast toaster4 = Toast.makeText(secret.this, "Le code secret n'est pas correct, veuillez réessayer !", Toast.LENGTH_SHORT);
                TextView view4 = toaster4.getView().findViewById(android.R.id.message);
                if (view4 != null) view4.setGravity(Gravity.CENTER);
                toaster4.show();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(this, "up-to-bottom");
    }
}
