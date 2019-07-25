package com.papple.iconoblast;

import android.content.Intent;
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
import static maes.tech.intentanim.CustomIntent.customType;

public class AscunsFragment extends Fragment {
    public MediaPlayer jaimeLesPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_ascuns, container, false);

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
        editor.putBoolean("asFrag", true);
        editor.putBoolean("deltaFrag", false);

        editor.apply();


        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        ScrollView sView = view.findViewById(R.id.ScrollASC);

        Button ascunsButton = view.findViewById(R.id.ascunsb);
        ascunsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.salut_sound);
            }
        });
        ascunsButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intentR = new Intent(getActivity(), secret.class);
                startActivity(intentR);
                customType(getActivity(), "bottom-to-up");
                return true;
            }
        });

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.ascuns));
            ViewCompat.setBackgroundTintList(ascunsButton, ColorStateList.valueOf(getResources().getColor(R.color.Green2)));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.dascuns));
            ViewCompat.setBackgroundTintList(ascunsButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen)));
        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.ascuns));
            ViewCompat.setBackgroundTintList(ascunsButton, ColorStateList.valueOf(getResources().getColor(R.color.Green2)));
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
