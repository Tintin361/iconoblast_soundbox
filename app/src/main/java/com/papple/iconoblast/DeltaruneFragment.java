package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class DeltaruneFragment extends Fragment {
    public MediaPlayer warmeurPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_deltarune, container, false);

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

        ScrollView sView = view.findViewById(R.id.ScrollDEL);

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.deltarune));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.ddelarune));
        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.deltarune));
        }


        final RecyclerView rView = view.findViewById(R.id.List);

        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        rView.setAdapter(new DeltaruneAdapter());


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
}
