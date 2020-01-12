package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

public class AcceuilFragment extends Fragment {
    private MediaPlayer jaimeLesPlayer; // Oui, bon le manque d'inspi ça arrive à tout le monde...

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acceuil, container, false);

        if (getActivity() == null) {
            return view;
        }

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toolbar.setLayoutParams(params);

        // Remember choice
        editor.putBoolean("aFrag", true);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);
        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);

        if (answerA) {
            cLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
            StatusBarUtil.setColor(getActivity(), getResources().getColor(android.R.color.white));

        } else if (answerB) {
            cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
            StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerA) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), android.R.color.white));
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && answerB) {
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.dddlc));
        }

        TextView text = view.findViewById(R.id.textView1);
        text.setOnClickListener(v -> playSound(R.raw.coucou_sound));
        text.setOnLongClickListener(view1 -> {
            playSound(R.raw.numous_addictio);
            return true;
        });

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
}
