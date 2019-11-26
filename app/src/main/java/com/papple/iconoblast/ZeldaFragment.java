package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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

public class ZeldaFragment extends Fragment implements Zelda_Adapter.OnItemClickListener, Zelda_Adapter_List.OnItemClickListener {
    private MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    Zelda_Adapter_List aAdapter;
    Zelda_Adapter aAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Zelda_Item_List_ListVersion> zeldaList;
    private ArrayList<Zelda_Item_List> zeldaList2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_zelda, container, false);

        if (getActivity() == null) {
            return view;
        }

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toolbar.setLayoutParams(params);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag",false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", true);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerA) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.zelda));
            cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));

        } else if (answerB) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
        }

        if (answerC) {
            zeldaList = new ArrayList<>();
            zeldaList.add(new Zelda_Item_List_ListVersion("Non, et tu t'amuse !!! (Ico)"));
            zeldaList.add(new Zelda_Item_List_ListVersion("Qu'est-ce que j'aimerais ... (Ico)"));
            zeldaList.add(new Zelda_Item_List_ListVersion("ZELDA !!! (Ico)"));
            zeldaList.add(new Zelda_Item_List_ListVersion("Chanson Ico et Étagère"));

            mRecyclerView = view.findViewById(R.id.zeldaRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter = new Zelda_Adapter_List(zeldaList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(aAdapter);
            aAdapter.setOnItemClickListener(this);
        } else if (answerD) {
            zeldaList2 = new ArrayList<>();
            zeldaList2.add(new Zelda_Item_List(R.drawable.amuse_image, "Non, et tu t'amuse !!! (Ico)"));
            zeldaList2.add(new Zelda_Item_List(R.drawable.main_image, "Qu'est-ce que j'aimerais ... (Ico)"));
            zeldaList2.add(new Zelda_Item_List(R.drawable.zelda_image, "ZELDA !!! (Ico)"));
            zeldaList2.add(new Zelda_Item_List(R.drawable.chanson_zelda_image, "Chanson Ico et Étagère"));


            mRecyclerView = view.findViewById(R.id.zeldaRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter2 = new Zelda_Adapter(zeldaList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(aAdapter2);
            aAdapter2.setOnItemClickListener(this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        return view;
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
                Zelda_Item_List_ListVersion currentItem = zeldaList.get(position);
                switch (currentItem.getText()) {
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
                }
            } else if (answerD) {
                Zelda_Item_List currentItem = zeldaList2.get(position);
                switch (currentItem.getZeldaText()) {
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
                }
            }
        }
    }
}
