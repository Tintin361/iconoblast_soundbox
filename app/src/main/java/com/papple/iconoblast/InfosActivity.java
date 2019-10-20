package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;

import static maes.tech.intentanim.CustomIntent.customType;

public class InfosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        SharedPreferences settings = InfosActivity.this.getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (Build.VERSION.SDK_INT >= 21) {
            if (answerA) {
                setTheme(R.style.AppTheme_NoActionBar);
                StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white));
            } else if (answerB) {
                setTheme(R.style.DarkTheme);
                StatusBarUtil.setColor(this, getResources().getColor(R.color.dddlc));
            } else {
                setTheme(R.style.AppTheme_NoActionBar);
                StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white));
            }
        } else {
            if (answerA) {
                setTheme(R.style.AppTheme_NoActionBar);
            } else if (answerB) {
                setTheme(R.style.DarkTheme);
            } else {
                setTheme(R.style.AppTheme_NoActionBar);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        RelativeLayout rLayout = findViewById(R.id.infoRelativeLayout);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        if (Build.VERSION.SDK_INT <= 19) {
            if (answerA) {
                rLayout.setBackgroundColor(getResources().getColor(R.color.white));
                bottomNav.setBackgroundColor(getResources().getColor(R.color.white));
            } else if (answerB) {
                rLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
                bottomNav.setBackgroundColor(getResources().getColor(R.color.dddlc));
            } else {
                rLayout.setBackgroundColor(getResources().getColor(R.color.white));
                bottomNav.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow);
        }

        if (answerA) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar);
        } else if (answerB) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar_dark);
        } else {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar);
        }

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
        customType(this, "left-to-right");
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(this, "left-to-right");
    }
}
