package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        Button guerrierButton = view.findViewById(R.id.guerriersb);
        guerrierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.guerrierdeltat);
            }
        });

        Button krisButton = view.findViewById(R.id.krisb);
        krisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.kris_sound);
            }
        });

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.deltarune));
            ViewCompat.setBackgroundTintList(guerrierButton, ColorStateList.valueOf(getResources().getColor(R.color.blue3)));
            ViewCompat.setBackgroundTintList(krisButton, ColorStateList.valueOf(getResources().getColor(R.color.blue4)));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.ddelarune));
            ViewCompat.setBackgroundTintList(guerrierButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue3)));
            ViewCompat.setBackgroundTintList(krisButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue4)));
        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.deltarune));
            ViewCompat.setBackgroundTintList(guerrierButton, ColorStateList.valueOf(getResources().getColor(R.color.blue4)));
            ViewCompat.setBackgroundTintList(krisButton, ColorStateList.valueOf(getResources().getColor(R.color.blue4)));
        }

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
