package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DdlcFragment extends Fragment implements Ddlc_Adapter_List.OnItemClickListener, Ddlc_Adapter.OnItemClickListener {
    public MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    Ddlc_Adapter_List dAdapter;
    Ddlc_Adapter dAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    public RelativeLayout relativeLayout;
    ArrayList<Ddlc_Item_List_ListVersion> ddlcList;
    ArrayList<Ddlc_Item_List> ddlcList2;
    Picasso.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ddlc, container, false);

        if (getActivity() == null) {
            return view;
        }

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", true);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        FrameLayout fLayout = getActivity().findViewById(R.id.fragment_container);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerA) {
            cLayout.setBackgroundColor(getResources().getColor(R.color.ddlc));
            getActivity().setTheme(R.style.AppTheme_NoActionBar2);
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.ddlc));
        } else if (answerB) {
            getActivity().setTheme(R.style.DarkTheme2);
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
        } else {
            cLayout.setBackgroundColor(getResources().getColor(R.color.ddlc));
            getActivity().setTheme(R.style.AppTheme_NoActionBar2);
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.ddlc));
        }

        if (answerC) {

            ddlcList = new ArrayList<>();
            ddlcList.add(new Ddlc_Item_List_ListVersion("C'est parce que j'veux ken !!! (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("HAHA !!! (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Donc tu devais peut-être… (Étagèrito)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Hey ! Fait attention… (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Étagère_sound.ogg"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("MMMMMMH !!! (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("GÉNIAL !!! (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("SUPER !!! (Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Rire (pas) diabolique (Grand Étagère)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("BAAAAKA !!! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Actuellement, je pense encore à… (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("CRACHE LE MORCEAU, ENCULÉ !!! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Iconoclaste_sound.ogg"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Non ! NOOOOOON !!! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("(Censuré) oh pardon, c'est sorti tout seul ! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Pour baiser ! POUR BAISER ! (Ico)"));
            ddlcList.add(new Ddlc_Item_List_ListVersion("Tu dis que de la merde ! SUPER ! (Ico et Étagère)"));

            mRecyclerView = view.findViewById(R.id.lunetteRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            dAdapter = new Ddlc_Adapter_List(ddlcList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(dAdapter);
            dAdapter.setOnItemClickListener(this);

        } else if (answerD) {

            ddlcList2 = new ArrayList<>();
            ddlcList2.add(new Ddlc_Item_List(R.drawable.ken_image, "C'est parce que j'veux ken !!! (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.haha_image, "HAHA !!! (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.nue_image, "Donc tu devais peut-être… (Étagèrito)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.atttntion_image, "Hey ! Fait attention… (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.etagere_image, "Étagère_sound.ogg"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.mhh_image, "MMMMMMH !!! (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.genial_image, "GÉNIAL !!! (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.super_image, "SUPER !!! (Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.experimenter_image, "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.rire_image, "Rire (pas) diabolique (Grand Étagère)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.tete_image, "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.baka_image, "BAAAAKA !!! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.caillioux_image, "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.m_image, "Actuellement, je pense encore à… (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.morceau_image, "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.ico_image, "Iconoclaste_sound.ogg"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.non_image, "Non ! NOOOOOON !!! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.ohoh_image, "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.baiser_image, "Pour baiser ! POUR BAISER ! (Ico)"));
            ddlcList2.add(new Ddlc_Item_List(R.drawable.merde_image, "Tu dis que de la merde ! SUPER ! (Ico et Étagère)"));

            mRecyclerView = view.findViewById(R.id.lunetteRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            dAdapter2 = new Ddlc_Adapter(ddlcList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(dAdapter2);
            dAdapter2.setOnItemClickListener(this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        return view;

    }

    public void playSound(int redId) {
        if (jaimeLesPlayer != null) {
            jaimeLesPlayer.stop();
            jaimeLesPlayer.release();
        }
        jaimeLesPlayer = MediaPlayer.create(getContext(), redId);
        jaimeLesPlayer.start();
    }

    @Override
    public void onItemClick(View v, int position) {

        if (getActivity() != null) {
            SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);

            boolean answerC = settings.getBoolean("questionC", false);
            boolean answerD = settings.getBoolean("questionD", false);

            if (answerC) {
                Ddlc_Item_List_ListVersion currentItem = ddlcList.get(position);
                switch (currentItem.getText()) {
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
                    case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                        playSound(R.raw.merde_sound);
                        break;
                }
            } else if (answerD) {
                Ddlc_Item_List currentItem = ddlcList2.get(position);
                switch (currentItem.getDdlcText()) {
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
                    case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                        playSound(R.raw.merde_sound);
                        break;
                }
            }
        }
    }
}
