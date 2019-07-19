package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class DeltaruneFragment extends Fragment implements Deltarune_Adapter.OnItemClickListener {
    public MediaPlayer warmeurPlayer;
    private RecyclerView mRecyclerView;
    private Deltarune_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_deltarune, container, false);
        relativeLayout = view.findViewById(R.id.LayoutNew);

        if (getActivity() == null) {
            return view;
        }

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

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.deltarune));
        } else if (answerB) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.ddelarune));
        } else {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.deltarune));
        }

        ArrayList<Deltarune_Item_List> deltaList = new ArrayList<>();
        deltaList.add(new Deltarune_Item_List(R.drawable.guerriers_delta, "Guerriers Delta !!! (Ico et Étagère)"));
        deltaList.add(new Deltarune_Item_List(R.drawable.kriseuh, "KRISEUH ! (Ico)"));

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new Deltarune_Adapter(deltaList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(DeltaruneFragment.this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;

    }

    public void playSound(int redId) {
        if (warmeurPlayer != null) {
            warmeurPlayer.stop();
            warmeurPlayer.release();
        }
        warmeurPlayer = MediaPlayer.create(getContext(), redId);
        warmeurPlayer.start();
    }

    @Override
    public void onItemClick(int position) {

    }
}
