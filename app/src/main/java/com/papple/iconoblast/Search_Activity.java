package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class Search_Activity extends AppCompatActivity implements Search_Adapter_List.OnItemClickListener{
    public MediaPlayer warmeurPlayer;
    RecyclerView mRecyclerView;
    Search_Adapter_List sAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    RelativeLayout rLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar2);
        } else if (answerB) {
            setTheme(R.style.DarkTheme2);
        } else {
            setTheme(R.style.AppTheme_NoActionBar2);
        }

        setContentView(R.layout.activity_search);

        Toolbar tBar = findViewById(R.id.toolbar_search);
        setSupportActionBar(tBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_upward);
        } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        }


        // Liste des Array
        ArrayList<Search_Item_List_ListVersion> searchList = new ArrayList<>();

        searchList.add(new Search_Item_List_ListVersion("C'est parce que j'veux ken !!! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("HAHA !!! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("BAAAAKA !!! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("CAILOOOOOUUUXXX !!! (encore Ico…)"));
        searchList.add(new Search_Item_List_ListVersion("Actuellement, je pense encore à… (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Donc tu devais peut-être… (Étagèrito)"));
        searchList.add(new Search_Item_List_ListVersion("CRACHE LE MORCEAU, ENCULÉ !!! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Hey ! Fait attention… (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Étagere_sound.ogg"));
        searchList.add(new Search_Item_List_ListVersion("Iconoclaste_sound.ogg"));
        searchList.add(new Search_Item_List_ListVersion("MMMMMMH !!! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("GÉNIAL !!! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Non ! NOOOOOON !!! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("SUPER !!! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)"));
        searchList.add(new Search_Item_List_ListVersion("(Censuré) oh pardon, c'est sorti tout seul ! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Rire (pas) diabolique (Grand Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Pour baiser ! POUR BAISER ! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Tu dis que de la merde ! SUPER ! (Ico et Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Mais c'est dégueulasse Addictio(Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Mais ta gueule !!! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("C'est un immense branleur ! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Lui, il fait des doigts d\\'honneur devant les portes ! (Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Tu vois là, on est baisés ! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("TOUCH MY COCK !!! (Ico et Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("Guerriers Delta !!! (Ico et Étagère)"));
        searchList.add(new Search_Item_List_ListVersion("KRISEUH ! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("ZELDA !!! (Ico)"));
        searchList.add(new Search_Item_List_ListVersion("Chanson Ico et Étagère"));
        searchList.add(new Search_Item_List_ListVersion("SALUUUUUUUUUTTT !!!!! (Ico)"));


        mRecyclerView = Search_Activity.this.findViewById(R.id.searchRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        sAdapter = new Search_Adapter_List(searchList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(sAdapter);
        sAdapter.setOnItemClickListener(Search_Activity.this);

        final EditText eText = findViewById(R.id.searchEditText);
        eText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sAdapter.getFilter().filter(s);
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

    public void playSound(int redId) {
        if (warmeurPlayer != null) {
            warmeurPlayer.stop();
            warmeurPlayer.release();
        }
        warmeurPlayer = MediaPlayer.create(this, redId);
        warmeurPlayer.start();
    }

    @Override
    public void onItemClick(View v, int position) {
    }
}
