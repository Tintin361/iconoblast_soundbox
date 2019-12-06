package com.papple.iconoblast;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

import static maes.tech.intentanim.CustomIntent.customType;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private long backPressedTime;
    private Toast toaster;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);
        boolean autoMajBoolean = settings.getBoolean("automaj", false);

        if (!answerA && !answerB) {
            editor.putBoolean("questionA", true);
            editor.putBoolean("questionB", false);
            editor.apply();
        }

        if (!answerC && !answerD) {
            editor.putBoolean("questionC", true).apply();
        }

        editor.putBoolean("automaj", false);
        editor.apply();

        if (autoMajBoolean) {
            AppUpdater app = new AppUpdater(MainActivity.this)
                    .setUpdateFrom(UpdateFrom.GITHUB)
                    .setGitHubUserAndRepo("Tintin361", "iconoblast_soundbox")
                    .setDisplay(Display.NOTIFICATION);
            app.start();
        }

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar2);
        } else if (answerB) {
            setTheme(R.style.DarkTheme2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (answerA) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar);
            navigationView.setBackgroundColor(getResources().getColor(android.R.color.white));

        } else if (answerB) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar_dark);
            navigationView.setBackgroundColor(getResources().getColor(R.color.dddlc));
        }

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
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_ascuns_icon))
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

            assert sManager != null;
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
            case R.id.share:
                shareMenu();
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
                customType(this, "right-to-left");
                break;
            case R.id.first_theme:
                Intent intent = new Intent(MainActivity.this, theme.class);
                startActivity(intent);
                customType(this, "left-to-right");
                break;
            case R.id.search:
                Intent searchIntent = new Intent(MainActivity.this, Search_Activity.class);
                startActivity(searchIntent);
                customType(this, "bottom-to-up");
        }

        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Redirection sur Github")
                .setMessage("Vous allez être redirigé(e) sur Github, la page va s'ouvrir dans l'application.")
                .setPositiveButton("Ok", (dialog, which) -> launchTabs())
                .setNegativeButton("Annuler", null)
                .show();
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
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                toaster.cancel();
                super.onBackPressed();
            } else {
                toaster = Toast.makeText(getBaseContext(), "Faites retour une seconde fois pour quitter.", Toast.LENGTH_SHORT);
                TextView view = toaster.getView().findViewById(android.R.id.message);
                if (view != null) view.setGravity(Gravity.CENTER);
                toaster.show();
            }
            backPressedTime = System.currentTimeMillis();
        }
    }

    public void launchTabs() {
        String url = "https://github.com/Tintin361/iconoblast_soundbox/releases";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
    }

    public void shareMenu() {
        new AlertDialog.Builder(this)
                .setTitle(Html.fromHtml("<font color='#ff1500'>Partager l'application</font>"))
                .setMessage("Vous pouvez partager l'application Iconoblast! avec vos amis via Google Drive ou Github.")
                .setPositiveButton(Html.fromHtml("<font color='#18A462'>Google Drive</font>"), (dialog, which) -> {
                    String url = "https://drive.google.com/drive/folders/1_YurNp0Pzzck8gWpGLNeD9GH0IBYK0LL?usp=sharing";

                    Intent sharringIntent = new Intent(Intent.ACTION_SEND);
                    sharringIntent.putExtra(Intent.EXTRA_TEXT, url);
                    sharringIntent.setType("text/plain");
                    startActivity(Intent.createChooser(sharringIntent, "Partager l'application"));
                })
                .setNegativeButton(Html.fromHtml("<font color='#F15135'>Github</font>"), (dialog, which) -> {
                    String url = "https://github.com/Tintin361/iconoblast_soundbox/releases";

                    Intent sharringIntent = new Intent(Intent.ACTION_SEND);
                    sharringIntent.putExtra(Intent.EXTRA_TEXT, url);
                    sharringIntent.setType("text/plain");
                    startActivity(Intent.createChooser(sharringIntent, "Partager l'application"));
                })
                .setNeutralButton("Annuler", (dialogInterface, i) -> dialogInterface.cancel())
                .show();
    }
}
