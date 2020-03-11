package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

public class MarioGalaxyFragment extends Fragment implements MarioGalaxy_Adapter_List.OnItemClickListener, MarioGalaxy_Adapter.OnItemClickListener {
    private MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    MarioGalaxy_Adapter_List gAdapter;
    MarioGalaxy_Adapter gAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<MarioGalaxy_Item_List_ListVersion> gList;
    ArrayList<MarioGalaxy_Item_List> gList2;
    boolean answerA;
    boolean answerB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_smg, container, false);

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
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("marioGalaxyFrag", true);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        cLayout.setBackgroundColor(getResources().getColor(R.color.ddlc));

        answerA = settings.getBoolean("questionA", false);
        answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerA) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.marioGalaxy));
            cLayout.setBackgroundColor(getResources().getColor(R.color.marioGalaxy));

        } else if (answerB) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerA) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.marioGalaxy));
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerB) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.dddlc));
        }

        if (answerC) {
            gList = new ArrayList<>();
            gList.add(new MarioGalaxy_Item_List_ListVersion("Ça rime avec... (Étagère.exe)"));
            gList.add(new MarioGalaxy_Item_List_ListVersion("Pute, pute... (Étagère)"));
            gList.add(new MarioGalaxy_Item_List_ListVersion("C'est parti ! (Ico)"));
            gList.add(new MarioGalaxy_Item_List_ListVersion("I'm cumming !!! (Ico)"));
            gList.add(new MarioGalaxy_Item_List_ListVersion("NOOOOOOOOOON ! (Ico)"));


            mRecyclerView = view.findViewById(R.id.galaxyRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            gAdapter = new MarioGalaxy_Adapter_List(gList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(gAdapter);
            gAdapter.setOnItemClickListener(this);

        } else if (answerD) {
            gList2 = new ArrayList<>();
            gList2.add(new MarioGalaxy_Item_List(R.drawable.rime_image, "Ça rime avec... (Étagère.exe)"));
            gList2.add(new MarioGalaxy_Item_List(R.drawable.put_image, "Pute, pute... (Étagère)"));
            gList2.add(new MarioGalaxy_Item_List(R.drawable.parti_image, "C'est parti ! (Ico)"));
            gList2.add(new MarioGalaxy_Item_List(R.drawable.cumming_image, "I'm cumming !!! (Ico)"));
            gList2.add(new MarioGalaxy_Item_List(R.drawable.nooon_image, "NOOOOOOOOOON ! (Ico)"));


            mRecyclerView = view.findViewById(R.id.galaxyRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            gAdapter2 = new MarioGalaxy_Adapter(gList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(gAdapter2);
            gAdapter2.setOnItemClickListener(this);

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
                MarioGalaxy_Item_List_ListVersion currentItem = gList.get(position);
                switch (currentItem.getText()) {
                    case "Ça rime avec... (Étagère.exe)":
                        playSound(R.raw.rime_sound);
                        break;
                    case "Pute, pute... (Étagère)":
                        playSound(R.raw.put_sound);
                        break;
                    case "C'est parti ! (Ico)":
                        playSound(R.raw.parti_sound);
                        break;
                    case "I'm cumming !!! (Ico)":
                        playSound(R.raw.cumming_sound);
                        break;
                    case "NOOOOOOOOOON ! (Ico)":
                        playSound(R.raw.nooon_sound);
                        break;
                }

            } else if (answerD) {
                MarioGalaxy_Item_List currentItem = gList2.get(position);

                switch (currentItem.getMarioGalaxyText()) {
                    case "Ça rime avec... (Étagère.exe)":
                        playSound(R.raw.rime_sound);
                        break;
                    case "Pute, pute... (Étagère)":
                        playSound(R.raw.put_sound);
                        break;
                    case "C'est parti ! (Ico)":
                        playSound(R.raw.parti_sound);
                        break;
                    case "I'm cumming !!! (Ico)":
                        playSound(R.raw.cumming_sound);
                        break;
                    case "NOOOOOOOOOON ! (Ico)":
                        playSound(R.raw.nooon_sound);
                        break;

                }
            }
        }
    }
}
