package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

public class MgtFragment extends Fragment implements Mgt_Adapter.OnItemClickListener, Mgt_Adapter_List.OnItemClickListener {
    private MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    Mgt_Adapter_List mAdapter;
    Mgt_Adapter mAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Mgt_Item_List_ListVersion> mgtList;
    private ArrayList<Mgt_Item_List> mgtList2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_mgt, container, false);

        if (getActivity() == null) {
            return view2;
        }

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toolbar.setLayoutParams(params);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        cLayout.setBackgroundColor(getResources().getColor(R.color.mgt));

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", true);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerA) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.mgt));
            cLayout.setBackgroundColor(getResources().getColor(R.color.mgt));

        } else if (answerB) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerA) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.mgt));
            view2.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerB) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.dddlc));
        }

        if (answerC) {
            mgtList = new ArrayList<>();
            mgtList.add(new Mgt_Item_List_ListVersion("C'est un immense branleur ! (Étagère)"));
            mgtList.add(new Mgt_Item_List_ListVersion("Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)"));
            mgtList.add(new Mgt_Item_List_ListVersion("Lui, il fait des doigts d'honneur devant les portes ! (Étagère)"));
            mgtList.add(new Mgt_Item_List_ListVersion("Mais c'est dégueulasse Addictio... (Ico)"));
            mgtList.add(new Mgt_Item_List_ListVersion("Mais ta gueule !!! (Ico)"));
            mgtList.add(new Mgt_Item_List_ListVersion("Tu vois là, on est baisés ! (Ico)"));
            mgtList.add(new Mgt_Item_List_ListVersion("TOUCH MY COCK !!! (Ico et Étagère)"));

            mRecyclerView = view2.findViewById(R.id.mgtRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            mAdapter = new Mgt_Adapter_List(mgtList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);

        } else if (answerD) {
            mgtList2 = new ArrayList<>();
            mgtList2.add(new Mgt_Item_List(R.drawable.branleur_image, "C'est un immense branleur ! (Étagère)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.mas_image, "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.doigt_image, "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.degueulasse_image, "Mais c'est dégueulasse Addictio... (Ico)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.gueule_image, "Mais ta gueule !!! (Ico)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.baise_image, "Tu vois là, on est baisés ! (Ico)"));
            mgtList2.add(new Mgt_Item_List(R.drawable.touch_my_cock, "TOUCH MY COCK !!! (Ico et Étagère)"));

            mRecyclerView = view2.findViewById(R.id.mgtRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            mAdapter2 = new Mgt_Adapter(mgtList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter2);
            mAdapter2.setOnItemClickListener(this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        return view2;
    }

    private void playSound(int redId) {
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
                Mgt_Item_List_ListVersion currentItem = mgtList.get(position);
                switch (currentItem.getText()) {
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
                }
            } else if (answerD) {
                Mgt_Item_List currentItem = mgtList2.get(position);
                switch (currentItem.getMgtText()) {
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
                }
            }
        }
    }
}
