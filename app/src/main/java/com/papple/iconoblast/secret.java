package com.papple.iconoblast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import static maes.tech.intentanim.CustomIntent.customType;

public class secret extends AppCompatActivity {
    public MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        final SharedPreferences settings = getSharedPreferences("Answers", 0);

        final boolean answerA = settings.getBoolean("questionA", false);
        final boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar2);
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white));
        } else if (answerB) {
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.transparent));
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
        } else if (answerB) {
            toolbar3.setBackgroundResource(R.drawable.rounded_toolbar_dark);
        } else {
            toolbar3.setBackgroundResource(R.drawable.rounded_toolbar);
        }

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.checkButton);
        final ScrollView scrollView = findViewById(R.id.secretLayout);

        SharedPreferences prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        String editTextvalue = prefs.getString("VALUE", "");
        editText.setText(editTextvalue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                } else if (editText.getText().toString().equals("Donald Trump")) {

                    View decorView = getWindow().getDecorView();
                    int visibility = View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(visibility);

                    toolbar3.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);

                    ScrollView sView = findViewById(R.id.secretLayout);
                    sView.setBackgroundResource(R.drawable.image);
                    StatusBarUtil.setTranslucent(secret.this);

                } else if (editText.getText().toString().equals("Claude")) {

                    scrollView.setRotation(-180);

                } else if (editText.getText().toString().equals("Tiki")) {

                    imageView.setBackgroundResource(R.drawable.faketiki);

                } else if (!editText.getText().toString().equals("K/DA - POP/STARS")) {

                    Toast toaster4 = Toast.makeText(secret.this, "Le code secret n'est pas correct, veuillez réessayer !", Toast.LENGTH_SHORT);
                    TextView view4 = toaster4.getView().findViewById(android.R.id.message);
                    if (view4 != null) view4.setGravity(Gravity.CENTER);
                    toaster4.show();

                }
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();

        EditText editText = findViewById(R.id.editText);
        String editTextValue = editText.getText().toString();

        SharedPreferences prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("VALUE", editTextValue);

        editor.apply();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void playSound(int redId) {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, redId);
        mPlayer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(this, "up-to-bottom");
    }
}
