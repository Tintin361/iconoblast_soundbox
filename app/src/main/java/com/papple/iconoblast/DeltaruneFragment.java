package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
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
import android.widget.RelativeLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

public class DeltaruneFragment extends Fragment implements Deltarune_Adapter.OnItemClickListener, Deltarune_Adapter_List.OnItemClickListener {
    private MediaPlayer warmeurPlayer;
    private RecyclerView mRecyclerView;
    private Deltarune_Adapter mAdapter;
    private Deltarune_Adapter_List dAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_deltarune, container, false);
        relativeLayout = view.findViewById(R.id.LayoutNew);

        if (getActivity() == null) {
            return view;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.deltarune));
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
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", true);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        cLayout.setBackgroundColor(getResources().getColor(R.color.deltarune));

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (answerC) {
            ArrayList<Deltarune_Item_List_ListVersion> deltaList = new ArrayList<>();
            deltaList.add(new Deltarune_Item_List_ListVersion( "Guerriers Delta !!! (Ico et Étagère)"));
            deltaList.add(new Deltarune_Item_List_ListVersion("KRISEUH ! (Ico)"));

            mRecyclerView = view.findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            dAdapter = new Deltarune_Adapter_List(deltaList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(dAdapter);
            dAdapter.setOnItemClickListener(this);

        } else if (answerD) {
            ArrayList<Deltarune_Item_List> deltaList = new ArrayList<>();
            deltaList.add(new Deltarune_Item_List(R.drawable.guerriers_delta, "Guerriers Delta !!! (Ico et Étagère)"));
            deltaList.add(new Deltarune_Item_List(R.drawable.kriseuh, "KRISEUH ! (Ico)"));

            mRecyclerView = view.findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            mAdapter = new Deltarune_Adapter(deltaList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        return view;

    }

    private void playSound(int redId) {
        if (warmeurPlayer != null) {
            warmeurPlayer.stop();
            warmeurPlayer.release();
        }
        warmeurPlayer = MediaPlayer.create(getContext(), redId);
        warmeurPlayer.start();
    }

    @Override
    public void onItemClick(View v, int position) {
        if (position == 0) {
            playSound(R.raw.guerrierdeltat);
        } else if (position == 1) {
            playSound(R.raw.kris_sound);
        }
    }
}
