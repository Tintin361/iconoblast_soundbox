package com.papple.iconoblast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar2);
        } else if (answerB) {
            setTheme(R.style.DarkTheme2);
        } else {
            setTheme(R.style.AppTheme_NoActionBar2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            ShortcutManager sManager = getSystemService(ShortcutManager.class);

            Intent DdlcIntent = new Intent(this, MainActivity.class)
                    .setAction("LOCATION_SHORTCUT")
                    .putExtra("receive", "ddlc");

            Intent MgtIntent = new Intent(this, MainActivity.class)
                    .setAction("LOCATION_SHORTCUT")
                    .putExtra("receive", "mgt");

            Intent ZeldaIntent = new Intent(this, MainActivity.class)
                    .setAction("LOCATION_SHORTCUT")
                    .putExtra("receive", "zelda");

            Intent AscunsIntent = new Intent(this, MainActivity.class)
                    .setAction("LOCATION_SHORTCUT")
                    .putExtra("receive", "ascuns");

            Intent DeltaIntent = new Intent(this, MainActivity.class)
                    .setAction("LOCATION_SHORTCUT")
                    .putExtra("receive", "deltarune");

            // Création des raccourcis + Annonce
            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "ddlc")
                    .setShortLabel("Doki Doki Litterature Club")
                    .setLongLabel("Doki Doki Litterature Club")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_ddlc))
                    .setRank(1)
                    .setIntent(DdlcIntent)
                    .build();

            ShortcutInfo shortcut2 = new ShortcutInfo.Builder(this, "mgt")
                    .setShortLabel("Mad Games Tycoon")
                    .setLongLabel("Mad Games Tycoon")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_mgt))
                    .setRank(2)
                    .setIntent(MgtIntent)
                    .build();

            ShortcutInfo shortcut3 = new ShortcutInfo.Builder(this, "zelda")
                    .setShortLabel("Zelda")
                    .setLongLabel("Zelda")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_zelda))
                    .setRank(4)
                    .setIntent(ZeldaIntent)
                    .build();

            ShortcutInfo shortcut4 = new ShortcutInfo.Builder(this, "ascuns")
                    .setShortLabel("Ascuns")
                    .setLongLabel("Ascuns")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_ascuns))
                    .setRank(5)
                    .setIntent(AscunsIntent)
                    .build();

            ShortcutInfo shortcut5 = new ShortcutInfo.Builder(this, "deltarune")
                    .setShortLabel("Deltarune")
                    .setLongLabel("Deltarune")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_deltarune))
                    .setRank(3)
                    .setIntent(DeltaIntent)
                    .build();

            sManager.setDynamicShortcuts(Arrays.asList(shortcut, shortcut2, shortcut3, shortcut4, shortcut5));

            String string = getIntent().getStringExtra("receive");

            if (string != null) {
                switch (string) {
                    case "ddlc":
                        editor.putBoolean("aFrag", false);
                        editor.putBoolean("sFrag", false);
                        editor.putBoolean("dFrag", true);
                        editor.putBoolean("deltaFrag", false);
                        editor.putBoolean("mFrag", false);
                        editor.putBoolean("zFrag", false);
                        editor.putBoolean("asFrag", false);
                        editor.apply();
                        break;
                    case "mgt":
                        editor.putBoolean("aFrag", false);
                        editor.putBoolean("sFrag", false);
                        editor.putBoolean("dFrag", false);
                        editor.putBoolean("deltaFrag", false);
                        editor.putBoolean("mFrag", true);
                        editor.putBoolean("zFrag", false);
                        editor.putBoolean("asFrag", false);
                        editor.apply();
                        break;
                    case "zelda":
                        editor.putBoolean("aFrag", false);
                        editor.putBoolean("sFrag", false);
                        editor.putBoolean("dFrag", false);
                        editor.putBoolean("mFrag", false);
                        editor.putBoolean("deltaFrag", false);
                        editor.putBoolean("zFrag", true);
                        editor.putBoolean("asFrag", false);
                        editor.apply();
                        break;
                    case "ascuns":
                        editor.putBoolean("aFrag", false);
                        editor.putBoolean("sFrag", false);
                        editor.putBoolean("dFrag", false);
                        editor.putBoolean("mFrag", false);
                        editor.putBoolean("deltaFrag", false);
                        editor.putBoolean("zFrag", false);
                        editor.putBoolean("asFrag", true);
                        editor.apply();
                        break;
                    case "deltarune":
                        editor.putBoolean("aFrag", false);
                        editor.putBoolean("sFrag", false);
                        editor.putBoolean("dFrag", false);
                        editor.putBoolean("mFrag", false);
                        editor.putBoolean("deltaFrag", true);
                        editor.putBoolean("zFrag", false);
                        editor.putBoolean("asFrag", false);
                        editor.apply();
                        break;

                }
            }
        }

        boolean acceuilFrag = settings.getBoolean("aFrag", false);
        boolean statFrag = settings.getBoolean("sFrag", false);
        boolean ddlcFrag = settings.getBoolean("dFrag", false);
        boolean mgtFrag = settings.getBoolean("mFrag", false);
        boolean deltaFrag = settings.getBoolean("deltaFrag", false);
        boolean zeldaFrag = settings.getBoolean("zFrag", false);
        boolean ascunsfrag = settings.getBoolean("asFrag", false);

        if (ddlcFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DdlcFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_ddlc);
        } else if (mgtFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MgtFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_mgt);
        } else if (deltaFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeltaruneFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_delta);
        } else if (zeldaFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ZeldaFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_zelda);
        } else if (ascunsfrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AscunsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_ascuns);
        } else if (acceuilFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AcceuilFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_acceuil);
        } else if (statFrag) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StatFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_stat);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AcceuilFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_acceuil);
        }


        if (answerA) {

            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.BLACK,
                    Color.parseColor("#3e068f"),
            };

            ColorStateList csl = new ColorStateList(state, color);


            // For Item
            int[][] states = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] colors = new int[]{
                    Color.parseColor("#777777"),
                    Color.parseColor("#3e068f")
            };

            ColorStateList cls1 = new ColorStateList(states, colors);

            navigationView.setItemTextColor(csl);
            navigationView.setItemIconTintList(cls1);

        } else if (answerB) {

            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.WHITE,
                    Color.parseColor("#4ac9f7"),
            };

            ColorStateList csl = new ColorStateList(state, color);


            // For Item
            int[][] states = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] colors = new int[]{
                    Color.parseColor("#BDBDBD"),
                    Color.parseColor("#4ac9f7")
            };

            ColorStateList cls1 = new ColorStateList(states, colors);

            navigationView.setItemTextColor(csl);
            navigationView.setItemIconTintList(cls1);

        } else {

            // For Text
            int[][] state = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] color = new int[]{
                    Color.BLACK,
                    Color.parseColor("#3e068f"),
            };
            // ou -checked (unchecked), un pour le texte et un pour l'icon puis un int[] pour les couleurs, une ColorStateList
            ColorStateList csl = new ColorStateList(state, color);

            // For Item
            int[][] states = new int[][]{
                    new int[]{-android.R.attr.state_checked}, // unchecked
                    new int[]{android.R.attr.state_checked}  // checked
            };

            int[] colors = new int[]{
                    Color.parseColor("#777777"),
                    Color.parseColor("#3e068f")
            };

            ColorStateList cls1 = new ColorStateList(states, colors);

            navigationView.setItemTextColor(csl);
            navigationView.setItemIconTintList(cls1);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        SharedPreferences sharedPreferences = getSharedPreferences("Number", 0);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();

        switch (item.getItemId()) {
            case R.id.nav_acceuil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AcceuilFragment()).commit();
                item.setChecked(true);
                break;
            case R.id.nav_stat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StatFragment()).commit();
                item.setChecked(true);
                break;
            case R.id.nav_ddlc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DdlcFragment()).commit();
                item.setChecked(true);
                int ddlcNumber = sharedPreferences.getInt("ddlc", 0);
                ddlcNumber = ddlcNumber + 1;
                editor1.putInt("ddlc", ddlcNumber);
                break;
            case R.id.nav_mgt:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MgtFragment()).commit();
                item.setChecked(true);
                int mgtNumber = sharedPreferences.getInt("mgt", 0);
                mgtNumber = mgtNumber + 1;
                editor1.putInt("mgt", mgtNumber);
                break;
            case R.id.nav_delta:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeltaruneFragment()).commit();
                item.setChecked(true);
                int deltaNumber = sharedPreferences.getInt("deltarune", 0);
                deltaNumber = deltaNumber + 1;
                editor1.putInt("deltarune", deltaNumber);
                break;
            case R.id.nav_yoshi:
                Toast.makeText(this, "Bébé de MERDE !!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_bloodborn:
                Toast.makeText(this, "Go to the LEFT, to the LEFT !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_amour:
                Toast.makeText(this, "Gnagnaniel !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_marioMaker:
                Toast.makeText(this, "Moi, ch'fais du bon level-design !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_sonic:
                Toast.makeText(this, "IT'S NO USE !!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_pokemon:
                Toast.makeText(this, "Osselait !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_versus:
                Toast.makeText(this, "TURBO-ÉTAGÈRE !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_zelda:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ZeldaFragment()).commit();
                item.setChecked(true);
                int zeldaNumber = sharedPreferences.getInt("zelda", 0);
                zeldaNumber = zeldaNumber + 1;
                editor1.putInt("zelda", zeldaNumber);
                break;
            case R.id.nav_ascuns:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AscunsFragment()).commit();
                item.setChecked(true);
                int ascunsNumber = sharedPreferences.getInt("ascuns", 0);
                ascunsNumber = ascunsNumber + 1;
                editor1.putInt("ascuns", ascunsNumber);
                break;
            case R.id.report:
                openContactDialog();
                break;
            case R.id.versionId:
                openDialog();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        editor1.apply();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.infos:
                Intent infoIntent = new Intent(MainActivity.this, InfosActivity.class);
                startActivity(infoIntent);
                break;
            case R.id.theme:
                Intent intent = new Intent(MainActivity.this, theme.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        Dialog_class dialog = new Dialog_class();
        dialog.show(getSupportFragmentManager(), "dialog_class");
    }

    public void openContactDialog() {
        contact_dialog dialog2 = new contact_dialog();
        dialog2.show(getSupportFragmentManager(), "contact_dialog");
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

}
