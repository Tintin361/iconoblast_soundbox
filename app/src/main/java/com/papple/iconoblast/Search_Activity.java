package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class Search_Activity extends AppCompatActivity implements Search_Adapter_List.OnItemClickListener, Search_Adapter.OnItemClickListener {
    public MediaPlayer warmeurPlayer;
    RecyclerView mRecyclerView;
    Search_Adapter_List sAdapter;
    Search_Adapter sAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Search_Item_List_ListVersion> searchList;
    ArrayList<Search_Item_List> searchList2;
    SharedPreferences settings;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);


        if (answerA) {
            setTheme(R.style.AppTheme_NoActionBar);
        } else if (answerB) {
            setTheme(R.style.DarkTheme);
        }

        setContentView(R.layout.activity_search);

        final Toolbar toolbar = findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);

        if (answerA) {
            StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white));
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar);

        } else if (answerB) {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.dddlc));
            toolbar.setBackgroundResource(R.drawable.rounded_toolbar_dark);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_upward);
        }

        if (answerC) {
            searchList = new ArrayList<>();

            searchList.add(new Search_Item_List_ListVersion("COUCOU LES COPAAAIIIINS !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("C'est parce que j'veux ken !!! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("HAHA !!! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Donc tu devais peut-être… (Étagèrito)"));
            searchList.add(new Search_Item_List_ListVersion("Hey ! Fait attention… (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Étagère_sound.ogg"));
            searchList.add(new Search_Item_List_ListVersion("MMMMMMH !!! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("GÉNIAL !!! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("SUPER !!! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)"));
            searchList.add(new Search_Item_List_ListVersion("Rire (pas) diabolique (Grand Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Tu as un cul énorme. (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("BAAAAKA !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)"));
            searchList.add(new Search_Item_List_ListVersion("Actuellement, je pense encore à… (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("CRACHE LE MORCEAU, ENCULÉ !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Iconoclaste_sound.ogg"));
            searchList.add(new Search_Item_List_ListVersion("Non ! NOOOOOON !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("(Censuré) oh pardon, c'est sorti tout seul ! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Pour baiser ! POUR BAISER ! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("EEEAAAAAARG ! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Tu dis que de la merde ! SUPER ! (Ico et Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("L'Étagère sonne creux... (Ico et Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Etemaaaaaaaaath !! (Ico et Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("C'est un immense branleur ! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Lui, il fait des doigts d'honneur devant les portes ! (Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Mais c'est dégueulasse Addictio... (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Mais ta gueule !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Tu vois là, on est baisés ! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("TOUCH MY COCK !!! (Ico et Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("Guerriers Delta !!! (Ico et Étagère)"));
            searchList.add(new Search_Item_List_ListVersion("KRISEUH ! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Non, et tu t'amuse !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Qu'est-ce que j'aimerais ... (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("ZELDA !!! (Ico)"));
            searchList.add(new Search_Item_List_ListVersion("Chanson Ico et Étagère"));
            searchList.add(new Search_Item_List_ListVersion("SALUUUUUUT !!!!! (Ico)"));


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

        } else if (answerD) {
            searchList2 = new ArrayList<>();

            searchList2.add(new Search_Item_List(R.drawable.copain_image, "COUCOU LES COPAAAIIIINS !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.ken_image, "C'est parce que j'veux ken !!! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.haha_image, "HAHA !!! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.nue_image, "Donc tu devais peut-être… (Étagèrito)"));
            searchList2.add(new Search_Item_List(R.drawable.atttntion_image, "Hey ! Fait attention… (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.etagere_image, "Étagère_sound.ogg"));
            searchList2.add(new Search_Item_List(R.drawable.mhh_image, "MMMMMMH !!! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.genial_image, "GÉNIAL !!! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.super_image, "SUPER !!! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.experimenter_image, "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)"));
            searchList2.add(new Search_Item_List(R.drawable.rire_image, "Rire (pas) diabolique (Grand Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.cul_image, "Tu as un cul énorme. (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.tete_image, "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.baka_image, "BAAAAKA !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.caillioux_image, "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)"));
            searchList2.add(new Search_Item_List(R.drawable.m_image, "Actuellement, je pense encore à… (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.morceau_image, "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.ico_image, "Iconoclaste_sound.ogg"));
            searchList2.add(new Search_Item_List(R.drawable.non_image, "Non ! NOOOOOON !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.ohoh_image, "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.baiser_image, "Pour baiser ! POUR BAISER ! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.eeeaaaaaarg_image, "EEEAAAAAARG ! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.merde_image, "Tu dis que de la merde ! SUPER ! (Ico et Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.letagere_image, "L'Étagère sonne creux... (Ico et Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.etemath_image, "Etemaaaaaaaaath !! (Ico et Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.branleur_image, "C'est un immense branleur ! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.mas_image, "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.doigt_image, "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.degueulasse_image, "Mais c'est dégueulasse Addictio... (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.gueule_image, "Mais ta gueule !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.baise_image, "Tu vois là, on est baisés ! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.touch_my_cock, "TOUCH MY COCK !!! (Ico et Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.guerriers_delta, "Guerriers Delta !!! (Ico et Étagère)"));
            searchList2.add(new Search_Item_List(R.drawable.kriseuh, "KRISEUH ! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.amuse_image, "Non, et tu t'amuse !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.main_image, "Qu'est-ce que j'aimerais ... (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.zelda_image, "ZELDA !!! (Ico)"));
            searchList2.add(new Search_Item_List(R.drawable.chanson_zelda_image, "Chanson Ico et Étagère"));
            searchList2.add(new Search_Item_List(R.drawable.salut_image, "SALUUUUUUT !!!!! (Ico)"));


            mRecyclerView = Search_Activity.this.findViewById(R.id.searchRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            sAdapter2 = new Search_Adapter(searchList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(sAdapter2);
            sAdapter2.setOnItemClickListener(Search_Activity.this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

            final EditText eText = findViewById(R.id.searchEditText);
            eText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    sAdapter2.getFilter().filter(s);
                }
            });
        }
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
        settings = getSharedPreferences("Answers", 0);

        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerC) {
            Search_Item_List_ListVersion currentItem = searchList.get(position);
            switch (currentItem.getText()) {
                case "COUCOU LES COPAAAIIIINS !!! (Ico)":
                    playSound(R.raw.coucou_sound);
                    break;
                case "C'est parce que j'veux ken !!! (Étagère)":
                    playSound(R.raw.ken_sound);
                    break;
                case "HAHA !!! (Étagère)":
                    playSound(R.raw.haha_sound);
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    playSound(R.raw.censure2_sound);
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    playSound(R.raw.attention_sound);
                    break;
                case "Étagère_sound.ogg":
                    playSound(R.raw.etagere_sound);
                    break;
                case "MMMMMMH !!! (Étagère)":
                    playSound(R.raw.mmm_sound);
                    break;
                case "GÉNIAL !!! (Étagère)":
                    playSound(R.raw.genial_sound);
                    break;
                case "SUPER !!! (Étagère)":
                    playSound(R.raw.super_sound);
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    playSound(R.raw.experimenter_sound);
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    playSound(R.raw.rire_sound);
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    playSound(R.raw.cul_sound);
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    playSound(R.raw.tete_sound);
                    break;
                case "BAAAAKA !!! (Ico)":
                    playSound(R.raw.baka_sound);
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    playSound(R.raw.cailloux_sound);
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    playSound(R.raw.censure_sound);
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    playSound(R.raw.morceau_sound);
                    break;
                case "Iconoclaste_sound.ogg":
                    playSound(R.raw.ico_sound);
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    playSound(R.raw.non_sound);
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    playSound(R.raw.pardon_sound);
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    playSound(R.raw.baiser_sound);
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    playSound(R.raw.eeeaaaaaarg_sound);
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    playSound(R.raw.merde_sound);
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    playSound(R.raw.letagere);
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    playSound(R.raw.etemath_sound);
                    break;
                case "C'est un immense branleur ! (Étagère)":
                    playSound(R.raw.branleur);
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    playSound(R.raw.masturber);
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    playSound(R.raw.doigt);
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    playSound(R.raw.degeu_sound);
                    break;
                case "Mais ta gueule !!! (Ico)":
                    playSound(R.raw.gueule_sound);
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    playSound(R.raw.baises);
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    playSound(R.raw.cock);
                    break;
                case "Guerriers Delta !!! (Ico et Étagère)":
                    playSound(R.raw.guerrierdeltat);
                    break;
                case "KRISEUH ! (Ico)":
                    playSound(R.raw.kris_sound);
                    break;
                case "Non, et tu t'amuse !!! (Ico)":
                    playSound(R.raw.amuse_sound);
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    playSound(R.raw.main_sound);
                    break;
                case "ZELDA !!! (Ico)":
                    playSound(R.raw.zelda_sound);
                    break;
                case "Chanson Ico et Étagère":
                    playSound(R.raw.chanson_zelda_sound);
                    break;
                case "SALUUUUUUT !!!!! (Ico)":
                    playSound(R.raw.salut_sound);
                    break;
            }
        } else if (answerD) {
            Search_Item_List currentItem = searchList2.get(position);
            switch (currentItem.getSearchText()) {
                case "COUCOU LES COPAAAIIIINS !!! (Ico)":
                    playSound(R.raw.coucou_sound);
                    break;
                case "C'est parce que j'veux ken !!! (Étagère)":
                    playSound(R.raw.ken_sound);
                    break;
                case "HAHA !!! (Étagère)":
                    playSound(R.raw.haha_sound);
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    playSound(R.raw.censure2_sound);
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    playSound(R.raw.attention_sound);
                    break;
                case "Étagère_sound.ogg":
                    playSound(R.raw.etagere_sound);
                    break;
                case "MMMMMMH !!! (Étagère)":
                    playSound(R.raw.mmm_sound);
                    break;
                case "GÉNIAL !!! (Étagère)":
                    playSound(R.raw.genial_sound);
                    break;
                case "SUPER !!! (Étagère)":
                    playSound(R.raw.super_sound);
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    playSound(R.raw.experimenter_sound);
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    playSound(R.raw.rire_sound);
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    playSound(R.raw.cul_sound);
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    playSound(R.raw.tete_sound);
                    break;
                case "BAAAAKA !!! (Ico)":
                    playSound(R.raw.baka_sound);
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    playSound(R.raw.cailloux_sound);
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    playSound(R.raw.censure_sound);
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    playSound(R.raw.morceau_sound);
                    break;
                case "Iconoclaste_sound.ogg":
                    playSound(R.raw.ico_sound);
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    playSound(R.raw.non_sound);
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    playSound(R.raw.pardon_sound);
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    playSound(R.raw.baiser_sound);
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    playSound(R.raw.eeeaaaaaarg_sound);
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    playSound(R.raw.merde_sound);
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    playSound(R.raw.letagere);
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    playSound(R.raw.etemath_sound);
                    break;
                case "C'est un immense branleur ! (Étagère)":
                    playSound(R.raw.branleur);
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    playSound(R.raw.masturber);
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    playSound(R.raw.doigt);
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    playSound(R.raw.degeu_sound);
                    break;
                case "Mais ta gueule !!! (Ico)":
                    playSound(R.raw.gueule_sound);
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    playSound(R.raw.baises);
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    playSound(R.raw.cock);
                    break;
                case "Guerriers Delta !!! (Ico et Étagère)":
                    playSound(R.raw.guerrierdeltat);
                    break;
                case "KRISEUH ! (Ico)":
                    playSound(R.raw.kris_sound);
                    break;
                case "Non, et tu t'amuse !!! (Ico)":
                    playSound(R.raw.amuse_sound);
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    playSound(R.raw.main_sound);
                    break;
                case "ZELDA !!! (Ico)":
                    playSound(R.raw.zelda_sound);
                    break;
                case "Chanson Ico et Étagère":
                    playSound(R.raw.chanson_zelda_sound);
                    break;
                case "SALUUUUUUT !!!!! (Ico)":
                    playSound(R.raw.salut_sound);
                    break;
            }
        }
    }
}
