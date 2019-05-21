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

public class MgtFragment extends Fragment {
    public MediaPlayer mrPlayer1009;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_mgt, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", true);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);

        editor.apply();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);


        ScrollView sView = view2.findViewById(R.id.scrollMGT);

        Button bButton = view2.findViewById(R.id.branleurb);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.branleur);
            }
        });

        Button mButton = view2.findViewById(R.id.masseb);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.masturber);
            }
        });

        Button dButton = view2.findViewById(R.id.doigtb);
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.doigt);
            }
        });

        Button degeuButton = view2.findViewById(R.id.degueulasseb);
        degeuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.degeu_sound);
            }
        });

        Button gueuleButton = view2.findViewById(R.id.gueuleb);
        gueuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.gueule_sound);
            }
        });

        Button baButton = view2.findViewById(R.id.baisesb);
        baButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.baises);
            }
        });

        Button cButton = view2.findViewById(R.id.cockb);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.cock);
            }
        });

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.mgt));
            // Change Background Tint
            ViewCompat.setBackgroundTintList(bButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(mButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
            ViewCompat.setBackgroundTintList(dButton, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(degeuButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
            ViewCompat.setBackgroundTintList(gueuleButton, ColorStateList.valueOf(getResources().getColor(R.color.green4)));
            ViewCompat.setBackgroundTintList(baButton, ColorStateList.valueOf(getResources().getColor(R.color.blue1)));
            ViewCompat.setBackgroundTintList(cButton, ColorStateList.valueOf(getResources().getColor(R.color.blue2)));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.dmgt));
            // Change Background Tint
            ViewCompat.setBackgroundTintList(bButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple)));
            ViewCompat.setBackgroundTintList(mButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple2)));
            ViewCompat.setBackgroundTintList(dButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue)));
            ViewCompat.setBackgroundTintList(degeuButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue2)));
            ViewCompat.setBackgroundTintList(gueuleButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue3)));
            ViewCompat.setBackgroundTintList(baButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue4)));
            ViewCompat.setBackgroundTintList(cButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen)));

        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.mgt));
            // Change Background Tint
            ViewCompat.setBackgroundTintList(bButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(mButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
            ViewCompat.setBackgroundTintList(dButton, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(degeuButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
            ViewCompat.setBackgroundTintList(gueuleButton, ColorStateList.valueOf(getResources().getColor(R.color.green4)));
            ViewCompat.setBackgroundTintList(baButton, ColorStateList.valueOf(getResources().getColor(R.color.blue1)));
            ViewCompat.setBackgroundTintList(cButton, ColorStateList.valueOf(getResources().getColor(R.color.blue2)));
        }


        return view2;
    }

    public void playSound(int redId) {
        if (mrPlayer1009 != null) {
            mrPlayer1009.stop();
            mrPlayer1009.release();
        }
        mrPlayer1009 = MediaPlayer.create(getContext(), redId);
        mrPlayer1009.start();
    }
}
