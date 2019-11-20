package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.core.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

public class MgtFragment extends Fragment {
    private MediaPlayer jaimeLesPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_mgt, container, false);

        if (getActivity() == null) {
            return view2;
        }

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toolbar.setLayoutParams(params);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);
        cLayout.setBackgroundColor(getResources().getColor(R.color.mgt));

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", true);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.mgt));
            cLayout.setBackgroundColor(getResources().getColor(R.color.mgt));
            getActivity().setTheme(R.style.AppTheme_NoActionBar2);
        } else if (answerB) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
            getActivity().setTheme(R.style.DarkTheme2);
        }

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
            ViewCompat.setBackgroundTintList(bButton, ColorStateList.valueOf(getResources().getColor(R.color.Red1)));
            ViewCompat.setBackgroundTintList(mButton, ColorStateList.valueOf(getResources().getColor(R.color.orange1)));
            ViewCompat.setBackgroundTintList(dButton, ColorStateList.valueOf(getResources().getColor(R.color.yellow1)));
            ViewCompat.setBackgroundTintList(degeuButton, ColorStateList.valueOf(getResources().getColor(R.color.green3)));
            ViewCompat.setBackgroundTintList(gueuleButton, ColorStateList.valueOf(getResources().getColor(R.color.green4)));
            ViewCompat.setBackgroundTintList(baButton, ColorStateList.valueOf(getResources().getColor(R.color.blue1)));
            ViewCompat.setBackgroundTintList(cButton, ColorStateList.valueOf(getResources().getColor(R.color.blue2)));

        } else if (answerB) {
            ViewCompat.setBackgroundTintList(bButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple)));
            ViewCompat.setBackgroundTintList(mButton, ColorStateList.valueOf(getResources().getColor(R.color.dPurple2)));
            ViewCompat.setBackgroundTintList(dButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue)));
            ViewCompat.setBackgroundTintList(degeuButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue2)));
            ViewCompat.setBackgroundTintList(gueuleButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue3)));
            ViewCompat.setBackgroundTintList(baButton, ColorStateList.valueOf(getResources().getColor(R.color.dBlue4)));
            ViewCompat.setBackgroundTintList(cButton, ColorStateList.valueOf(getResources().getColor(R.color.dGreen)));
        }
        return view2;
    }

    private void playSound(int redId) {
        if (jaimeLesPlayer != null) {
            jaimeLesPlayer.stop();
            jaimeLesPlayer.release();
        }
        jaimeLesPlayer = MediaPlayer.create(getContext(), redId);
        jaimeLesPlayer.start();
    }
}
