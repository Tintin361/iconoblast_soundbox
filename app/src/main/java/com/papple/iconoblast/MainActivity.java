package com.papple.iconoblast;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
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

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.navigation.NavigationView;

import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

import static maes.tech.intentanim.CustomIntent.customType;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private long backPressedTime;
    private Toast toaster;
    private Boolean lenvers;
    private FloatingActionMenu fabMenu;
    private FloatingActionButton fabButton;
    private FloatingActionButton hidButton;
    private Boolean pinSupport;
    private boolean answerA;
    private boolean answerB;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        SharedPreferences settings = getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        answerA = settings.getBoolean("questionA", false);
        answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);
        boolean autoMajBoolean = settings.getBoolean("automaj", false);
        boolean fabBoolean = settings.getBoolean("fabButton", false);
        lenvers = settings.getBoolean("lenvers", false);

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
            setTheme(R.style.AppTheme_MainTheme);
        } else if (answerB) {
            setTheme(R.style.DarkTheme2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= 26) {
            ShortcutManager sM = getSystemService(ShortcutManager.class);
            pinSupport = sM.isRequestPinShortcutSupported();
        }

        fabMenu = findViewById(R.id.fabMenu);
        fabButton = findViewById(R.id.shortButton);
        hidButton = findViewById(R.id.hideButton);

        if (fabBoolean && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && pinSupport) {

            ShortcutManager sM = getSystemService(ShortcutManager.class);
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

            // Création des raccourcis
            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "ddlc")
                    .setShortLabel("Doki Doki Litterature Club")
                    .setLongLabel("Doki Doki Litterature Club")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_ddlc))
                    .setIntent(DdlcIntent)
                    .build();

            ShortcutInfo shortcut2 = new ShortcutInfo.Builder(this, "mgt")
                    .setShortLabel("Mad Games Tycoon")
                    .setLongLabel("Mad Games Tycoon")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_mgt))
                    .setIntent(MgtIntent)
                    .build();

            ShortcutInfo shortcut3 = new ShortcutInfo.Builder(this, "zelda")
                    .setShortLabel("Zelda")
                    .setLongLabel("Zelda")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_zelda))
                    .setIntent(ZeldaIntent)
                    .build();

            ShortcutInfo shortcut4 = new ShortcutInfo.Builder(this, "ascuns")
                    .setShortLabel("Ascuns")
                    .setLongLabel("Ascuns")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_ascuns_icon))
                    .setIntent(AscunsIntent)
                    .build();

            ShortcutInfo shortcut5 = new ShortcutInfo.Builder(this, "deltarune")
                    .setShortLabel("Deltarune")
                    .setLongLabel("Deltarune")
                    .setDisabledMessage("Ce raccourci est désactivé.")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_deltarune))
                    .setIntent(DeltaIntent)
                    .build();

            fabButton.setOnClickListener(view -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                TextView title = new TextView(this);
                title.setText(R.string.dialogTitle);
                title.setGravity(Gravity.CENTER);
                title.setTextSize(25);
                title.setTextColor(ContextCompat.getColor(this, R.color.blue3));
                builder.setCustomTitle(title);

                @SuppressLint("InflateParams") final View customLayout = getLayoutInflater().inflate(R.layout.dialog_view, null);
                builder.setView(customLayout);

                builder.setNegativeButton("Annuler", (dialogInterface, i) -> dialogInterface.cancel());
                builder.setPositiveButton("Ajouter", (dialogInterface, i) -> {
                    RadioGroup radGroup = customLayout.findViewById(R.id.radGroup);
                    RadioButton radio1 = customLayout.findViewById(R.id.rad1);
                    RadioButton radio2 = customLayout.findViewById(R.id.rad2);
                    RadioButton radio3 = customLayout.findViewById(R.id.rad3);
                    RadioButton radio4 = customLayout.findViewById(R.id.rad4);
                    RadioButton radio5 = customLayout.findViewById(R.id.rad5);

                    if (radio1.isChecked() || radio2.isChecked() || radio3.isChecked() || radio4.isChecked() || radio5.isChecked()) {
                        int radioID = radGroup.getCheckedRadioButtonId();
                        View radioButton = radGroup.findViewById(radioID);
                        int idx = radGroup.indexOfChild(radioButton);

                        RadioButton r = (RadioButton) radGroup.getChildAt(idx);
                        String selText = r.getText().toString();


                        if (selText.equals("Doki Doki Litterature Club")) {
                            sM.setDynamicShortcuts(Collections.singletonList(shortcut));

                            ShortcutInfo pinShortInfo = new ShortcutInfo
                                    .Builder(MainActivity.this, "ddlc")
                                    .build();
                            Intent pinnedShortcutCallbackIntent = sM.createShortcutResultIntent(pinShortInfo);

                            PendingIntent successCB = PendingIntent.getBroadcast(MainActivity.this, 0, pinnedShortcutCallbackIntent, 0);
                            sM.requestPinShortcut(pinShortInfo, successCB.getIntentSender());

                        } else if (selText.equals("Mad Games Tycoon")) {
                            sM.setDynamicShortcuts(Collections.singletonList(shortcut2));

                            ShortcutInfo pinShortInfo = new ShortcutInfo
                                    .Builder(MainActivity.this, "mgt")
                                    .build();
                            Intent pinnedShortcutCallbackIntent = sM.createShortcutResultIntent(pinShortInfo);

                            PendingIntent successCB = PendingIntent.getBroadcast(MainActivity.this, 0, pinnedShortcutCallbackIntent, 0);
                            sM.requestPinShortcut(pinShortInfo, successCB.getIntentSender());

                        } else if (selText.equals("Deltarune")) {
                            sM.setDynamicShortcuts(Collections.singletonList(shortcut5));

                            ShortcutInfo pinShortInfo = new ShortcutInfo
                                    .Builder(MainActivity.this, "deltarune")
                                    .build();
                            Intent pinnedShortcutCallbackIntent = sM.createShortcutResultIntent(pinShortInfo);

                            PendingIntent successCB = PendingIntent.getBroadcast(MainActivity.this, 0, pinnedShortcutCallbackIntent, 0);
                            sM.requestPinShortcut(pinShortInfo, successCB.getIntentSender());

                        } else if (selText.equals("Zelda")) {
                            sM.setDynamicShortcuts(Collections.singletonList(shortcut3));

                            ShortcutInfo pinShortInfo = new ShortcutInfo
                                    .Builder(MainActivity.this, "zelda")
                                    .build();
                            Intent pinnedShortcutCallbackIntent = sM.createShortcutResultIntent(pinShortInfo);

                            PendingIntent successCB = PendingIntent.getBroadcast(MainActivity.this, 0, pinnedShortcutCallbackIntent, 0);
                            sM.requestPinShortcut(pinShortInfo, successCB.getIntentSender());

                        } else if (selText.equals("Ascuns")) {
                            sM.setDynamicShortcuts(Collections.singletonList(shortcut4));

                            ShortcutInfo pinShortInfo = new ShortcutInfo
                                    .Builder(MainActivity.this, "ascuns")
                                    .build();
                            Intent pinnedShortcutCallbackIntent = sM.createShortcutResultIntent(pinShortInfo);

                            PendingIntent successCB = PendingIntent.getBroadcast(MainActivity.this, 0, pinnedShortcutCallbackIntent, 0);
                            sM.requestPinShortcut(pinShortInfo, successCB.getIntentSender());

                        }
                    }
                });

                AlertDialog dialog = builder.create();
                if (answerA) {
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);

                } else if (answerB) {
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_dark);
                }
                dialog.show();

                Button b1 = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button b2 = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

                b1.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
                b1.setTextSize(15);
                b2.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
                b2.setTextSize(15);

            });

        } else if (!fabBoolean) {
            fabButton.hideButtonInMenu(true);

        }

        hidButton.setOnClickListener(view5 -> {
            fabMenu.hideMenu(true);
            editor.putBoolean("fabButton", false);
            editor.apply();
        });

        FloatingActionButton shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(view2 -> {
            String url = "https://play.google.com/store/apps/details?id=com.papple.iconoblast&gl=FR";
            ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setChooserTitle("Partager l'application")
                    .setText(url)
                    .startChooser();
        });

        FloatingActionButton bugButton = findViewById(R.id.bugButton);
        bugButton.setOnClickListener(view3 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            TextView title = new TextView(this);
            title.setText(R.string.bug);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(25);
            title.setTextColor(ContextCompat.getColor(this, R.color.blue3));
            builder.setCustomTitle(title);

            @SuppressLint("InflateParams") final View customLayout = getLayoutInflater().inflate(R.layout.dialog_model, null);
            TextView textView = customLayout.findViewById(R.id.placeholderText);
            textView.setText("Vous pouvez signaler un bug via la page Google Play Store ou par E-Mail.");
            builder.setView(customLayout);

            builder.setNeutralButton("Annuler", (dialogInterface, i) -> dialogInterface.cancel());
            builder.setPositiveButton("Google Play", (dialogInterface, i) -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String url = "https://play.google.com/store/apps/details?id=com.papple.iconoblast&gl=FR";
                intent.setData(Uri.parse(url));
                startActivity(intent);
            });
            builder.setNegativeButton("Mail", (dialogInterface, i) -> {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tintin361official@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Bug - Iconoblast !");
                startActivity(Intent.createChooser(intent, "Choisissez un client E-Mail."));
            });


            AlertDialog dialog = builder.create();
            if (answerA) {
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
            } else if (answerB) {
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_dark);
            }
            dialog.show();

            Button b1 = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            Button b2 = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            Button b3 = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);

            b1.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
            b1.setTextSize(15);
            b2.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
            b2.setTextSize(15);
            b3.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
            b3.setTextSize(15);
        });

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (answerA) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar);
            navigationView.setBackgroundColor(getResources().getColor(android.R.color.white));
            setTheme(R.style.AppTheme_MainTheme);

        } else if (answerB) {
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar_dark);
            navigationView.setBackgroundColor(getResources().getColor(R.color.dddlc));
            setTheme(R.style.DarkTheme2);

        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (lenvers) {
            LinearLayout lLayout = findViewById(R.id.linearLayout);
            lLayout.setRotation(-180);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
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
        }
        drawer.closeDrawer(GravityCompat.START);
        editor1.apply();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        if (lenvers) {
            CardView cardView = findViewById(R.id.menuCardview);
            cardView.setRotation(-180);
        }
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
                break;
        }

        return super.onOptionsItemSelected(item);
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
}
