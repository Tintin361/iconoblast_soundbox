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
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class ZeldaFragment extends Fragment {
    public MediaPlayer jaimeLesPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zelda, container, false);

        if (getActivity() == null) {
            return view;
        }

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


        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        ScrollView sView = view.findViewById(R.id.ScrollZelda);

        Button zeldaButton = view.findViewById(R.id.zeldab);
        zeldaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.zelda_sound);
            }
        });

        Button chansonButton = view.findViewById(R.id.chansonb);
        chansonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.chanson_zelda_sound); }});

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.zelda));
            ViewCompat.setBackgroundTintList(zeldaButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(chansonButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.dzelda));
            ViewCompat.setBackgroundTintList(zeldaButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue)));
            ViewCompat.setBackgroundTintList(chansonButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue2)));
        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.zelda));
            ViewCompat.setBackgroundTintList(zeldaButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(chansonButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
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
}
