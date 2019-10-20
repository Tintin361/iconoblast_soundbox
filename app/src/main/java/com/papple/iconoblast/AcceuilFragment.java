package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

public class AcceuilFragment extends Fragment {
    public MediaPlayer jaimeLesPlayer; // Oui, bon le manque d'inspi ça arrive à tout le monde...

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acceuil, container, false);

        if (getActivity() == null) {
            return view;
        }

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

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

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (getActivity() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (answerA) {
                    cLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
                    getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                    StatusBarUtil.setColor(getActivity(), getResources().getColor(android.R.color.white));
                } else if (answerB) {
                    getActivity().setTheme(R.style.DarkTheme2);
                    cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
                    StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dddlc));
                } else {
                    cLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
                    getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                    StatusBarUtil.setColor(getActivity(), getResources().getColor(android.R.color.white));
                }
            } else {
                if (answerA) {
                    cLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
                    getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                } else if (answerB) {
                    getActivity().setTheme(R.style.DarkTheme2);
                    cLayout.setBackgroundColor(getResources().getColor(R.color.dddlc));
                } else {
                    cLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
                    getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                }
            }
        }


        TextView text = view.findViewById(R.id.textView1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.coucou_sound);
            }
        });
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
