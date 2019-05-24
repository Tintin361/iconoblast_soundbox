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

public class DdlcFragment extends Fragment {
    public MediaPlayer darakaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ddlc, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", true);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);

        editor.apply();


        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        ScrollView sView = view.findViewById(R.id.scrollView2);

        Button kenButton = view.findViewById(R.id.kenb);
        kenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.ken_sound);
            }
        });

        Button hahaButton = view.findViewById(R.id.hahab);
        hahaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.haha_sound);
            }
        });

        Button censure2Button = view.findViewById(R.id.censure2b);
        censure2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.censure2_sound);
            }
        });

        Button attentionButton = view.findViewById(R.id.attentionb);
        attentionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.attention_sound);
            }
        });

        Button etagereButton = view.findViewById(R.id.etagereb);
        etagereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.etagere_sound);
            }
        });

        Button mmmButton = view.findViewById(R.id.mmmb);
        mmmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.mmm_sound);
            }
        });

        Button genialButton = view.findViewById(R.id.genialb);
        genialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.genial_sound);
            }
        });

        Button superButton = view.findViewById(R.id.superb);
        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.super_sound);
            }
        });

        Button experimenterButton = view.findViewById(R.id.experimenterb);
        experimenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.experimenter_sound);
            }
        });

        Button rireButton = view.findViewById(R.id.rireb);
        rireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.rire_sound);
            }
        });

        Button teteButton = view.findViewById(R.id.teteb);
        teteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.tete_sound);
            }
        });

        Button bakaButton = view.findViewById(R.id.bakab);
        bakaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.baka_sound);
            }
        });

        Button caillouxButton = view.findViewById(R.id.caillouxb);
        caillouxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.cailloux_sound);
            }
        });

        Button censureButton = view.findViewById(R.id.censureb);
        censureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.censure_sound);
            }
        });

        Button morceauButton = view.findViewById(R.id.morceaub);
        morceauButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { playSound(R.raw.morceau_sound);
            }
        });

        Button icoButton = view.findViewById(R.id.icob);
        icoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.ico_sound);
            }
        });

        Button nonButton = view.findViewById(R.id.nonb);
        nonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.non_sound);
            }
        });

        Button pardonButton = view.findViewById(R.id.pardonb);
        pardonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.pardon_sound);
            }
        });

        Button baiserButton = view.findViewById(R.id.baiserb);
        baiserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.baiser_sound);
            }
        });

        Button merdeButton = view.findViewById(R.id.merdeb);
        merdeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.merde_sound);
            }
        });

        if (answerA) {
            sView.setBackgroundColor(getResources().getColor(R.color.ddlc));
            ViewCompat.setBackgroundTintList(kenButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(hahaButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
            ViewCompat.setBackgroundTintList(censure2Button, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(attentionButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
            ViewCompat.setBackgroundTintList(etagereButton, ColorStateList.valueOf(getResources().getColor(R.color.green4)));
            ViewCompat.setBackgroundTintList(mmmButton, ColorStateList.valueOf(getResources().getColor(R.color.blue1)));
            ViewCompat.setBackgroundTintList(genialButton, ColorStateList.valueOf(getResources().getColor(R.color.blue2)));
            ViewCompat.setBackgroundTintList(superButton, ColorStateList.valueOf(getResources().getColor(R.color.blue3)));
            ViewCompat.setBackgroundTintList(experimenterButton, ColorStateList.valueOf(getResources().getColor(R.color.blue4)));
            ViewCompat.setBackgroundTintList(rireButton, ColorStateList.valueOf(getResources().getColor(R.color.blue5)));
            ViewCompat.setBackgroundTintList(teteButton, ColorStateList.valueOf(getResources().getColor(R.color.darkBlue)));
            ViewCompat.setBackgroundTintList(bakaButton, ColorStateList.valueOf(getResources().getColor(R.color.purple)));
            ViewCompat.setBackgroundTintList(caillouxButton, ColorStateList.valueOf(getResources().getColor(R.color.purple2)));
            ViewCompat.setBackgroundTintList(censureButton, ColorStateList.valueOf(getResources().getColor(R.color.pink1)));
            ViewCompat.setBackgroundTintList(morceauButton, ColorStateList.valueOf(getResources().getColor(R.color.pink2)));
            ViewCompat.setBackgroundTintList(icoButton, ColorStateList.valueOf(getResources().getColor(R.color.red2)));
            ViewCompat.setBackgroundTintList(nonButton, ColorStateList.valueOf(getResources().getColor(R.color.red3)));
            ViewCompat.setBackgroundTintList(pardonButton, ColorStateList.valueOf(getResources().getColor(R.color.orange2)));
            ViewCompat.setBackgroundTintList(baiserButton, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(merdeButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
        } else if (answerB) {
            sView.setBackgroundColor(getResources().getColor(R.color.dddlc));
            ViewCompat.setBackgroundTintList(kenButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple)));
            ViewCompat.setBackgroundTintList(hahaButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple2)));
            ViewCompat.setBackgroundTintList(censure2Button, ColorStateList.valueOf(getResources().getColor(R.color.dBlue)));
            ViewCompat.setBackgroundTintList(attentionButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue2)));
            ViewCompat.setBackgroundTintList(etagereButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue3)));
            ViewCompat.setBackgroundTintList(mmmButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue4)));
            ViewCompat.setBackgroundTintList(genialButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen)));
            ViewCompat.setBackgroundTintList(superButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen2)));
            ViewCompat.setBackgroundTintList(experimenterButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen3)));
            ViewCompat.setBackgroundTintList(rireButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen4)));
            ViewCompat.setBackgroundTintList(teteButton, ColorStateList.valueOf(getResources().getColor(R.color.dYellow)));
            ViewCompat.setBackgroundTintList(bakaButton, ColorStateList.valueOf(getResources().getColor(R.color.dOrange)));
            ViewCompat.setBackgroundTintList(caillouxButton, ColorStateList.valueOf(getResources().getColor(R.color.dRed)));
            ViewCompat.setBackgroundTintList(censureButton, ColorStateList.valueOf(getResources().getColor(R.color.dRed2)));
            ViewCompat.setBackgroundTintList(morceauButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple3)));
            ViewCompat.setBackgroundTintList(icoButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple)));
            ViewCompat.setBackgroundTintList(nonButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple2)));
            ViewCompat.setBackgroundTintList(pardonButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue)));
            ViewCompat.setBackgroundTintList(baiserButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue2)));
            ViewCompat.setBackgroundTintList(merdeButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue3)));
        } else {
            sView.setBackgroundColor(getResources().getColor(R.color.ddlc));
            ViewCompat.setBackgroundTintList(kenButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(hahaButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
            ViewCompat.setBackgroundTintList(censure2Button, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(attentionButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
            ViewCompat.setBackgroundTintList(etagereButton, ColorStateList.valueOf(getResources().getColor(R.color.green4)));
            ViewCompat.setBackgroundTintList(mmmButton, ColorStateList.valueOf(getResources().getColor(R.color.blue1)));
            ViewCompat.setBackgroundTintList(genialButton, ColorStateList.valueOf(getResources().getColor(R.color.blue2)));
            ViewCompat.setBackgroundTintList(superButton, ColorStateList.valueOf(getResources().getColor(R.color.blue3)));
            ViewCompat.setBackgroundTintList(experimenterButton, ColorStateList.valueOf(getResources().getColor(R.color.blue4)));
            ViewCompat.setBackgroundTintList(rireButton, ColorStateList.valueOf(getResources().getColor(R.color.blue5)));
            ViewCompat.setBackgroundTintList(teteButton, ColorStateList.valueOf(getResources().getColor(R.color.darkBlue)));
            ViewCompat.setBackgroundTintList(bakaButton, ColorStateList.valueOf(getResources().getColor(R.color.purple)));
            ViewCompat.setBackgroundTintList(caillouxButton, ColorStateList.valueOf(getResources().getColor(R.color.purple2)));
            ViewCompat.setBackgroundTintList(censureButton, ColorStateList.valueOf(getResources().getColor(R.color.pink1)));
            ViewCompat.setBackgroundTintList(morceauButton, ColorStateList.valueOf(getResources().getColor(R.color.pink2)));
            ViewCompat.setBackgroundTintList(icoButton, ColorStateList.valueOf(getResources().getColor(R.color.red2)));
            ViewCompat.setBackgroundTintList(nonButton, ColorStateList.valueOf(getResources().getColor(R.color.red3)));
            ViewCompat.setBackgroundTintList(pardonButton, ColorStateList.valueOf(getResources().getColor(R.color.orange2)));
            ViewCompat.setBackgroundTintList(baiserButton, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(merdeButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
        }

        return view;

    }

    public void playSound(int redId) {
        if (darakaPlayer != null) {
            darakaPlayer.stop();
            darakaPlayer.release();
        }
        darakaPlayer = MediaPlayer.create(getContext(), redId);
        darakaPlayer.start();
    }
}
