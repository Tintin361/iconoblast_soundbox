package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class InfosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        SharedPreferences settings = InfosActivity.this.getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            setTheme(R.style.AppTheme);
        } else if (answerB) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        Toolbar toolbar4 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar4);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (answerA) {

            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.parseColor("#757575"),
                    Color.parseColor("#3e068f")
            };

            ColorStateList cls = new ColorStateList(state, color);

            bottomNav.setItemTextColor(cls);
            bottomNav.setItemIconTintList(cls);

        } else if (answerB) {

            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.parseColor("#BCBCBC"),
                    Color.parseColor("#4ac9f7")
            };

            ColorStateList cls = new ColorStateList(state, color);

            bottomNav.setItemTextColor(cls);
            bottomNav.setItemIconTintList(cls);

        } else {


            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.parseColor("#757575"),
                    Color.parseColor("#3e068f")
            };

            ColorStateList cls = new ColorStateList(state, color);

            bottomNav.setItemTextColor(cls);
            bottomNav.setItemIconTintList(cls);

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_info, new TintinFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_tintin:
                    selectedFragment = new TintinFragment();
                    break;
                case R.id.nav_lulu:
                    selectedFragment = new LuluFragment();
                    break;
                case R.id.nav_iconoblast:
                    selectedFragment = new IcoFragment();
                    break;
                case R.id.nav_licences:
                    selectedFragment = new LicencesFragment();
                    break;
            }


            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_info, selectedFragment).commit();
                return true;
            }
            return true;
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
