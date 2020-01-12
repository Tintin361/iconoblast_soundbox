package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class AscunsFragment extends Fragment implements Ascuns_Adapter_List.OnItemClickListener, Ascuns_Adapter.OnItemClickListener {
    private MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    Ascuns_Adapter_List aAdapter;
    Ascuns_Adapter aAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Ascuns_Item_List_ListVersion> ascunsList;
    ArrayList<Ascuns_Item_List> ascunsList2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ascuns, container, false);

        if (getActivity() == null) {
            return view;
        }

        androidx.appcompat.widget.Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toolbar.setLayoutParams(params);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", true);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerA) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.ascuns));
            cLayout.setBackgroundColor(getResources().getColor(R.color.ascuns));

        } else if (answerB) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerA) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.ascuns));
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerB) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.dddlc));
        }

        if (answerC) {
            ascunsList = new ArrayList<>();
            ascunsList.add(new Ascuns_Item_List_ListVersion("SALUUUUUUT !!!!! (Ico)"));

            mRecyclerView = view.findViewById(R.id.ascunsRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter = new Ascuns_Adapter_List(ascunsList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(aAdapter);
            aAdapter.setOnItemClickListener(this);

        } else if (answerD) {
            ascunsList2 = new ArrayList<>();
            ascunsList2.add(new Ascuns_Item_List(R.drawable.salut_image, "SALUUUUUUT !!!!! (Ico)"));

            mRecyclerView = view.findViewById(R.id.ascunsRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter2 = new Ascuns_Adapter(ascunsList2);

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
                Ascuns_Item_List_ListVersion currentItem = ascunsList.get(position);
                switch (currentItem.getText()) {
                    case "SALUUUUUUT !!!!! (Ico)":
                        playSound(R.raw.salut_sound);
                        break;
                }
            } else if (answerD) {
                Ascuns_Item_List currentItem = ascunsList2.get(position);
                switch (currentItem.getAscunsText()) {
                    case "SALUUUUUUT !!!!! (Ico)":
                        playSound(R.raw.salut_sound);
                        break;
                }
            }
        }
    }
}
