package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;

public class StatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.fragment_stat, container, false);

        if(getActivity() == null) return v;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarUtil.setColor(getActivity(), getResources().getColor(android.R.color.white));
        }

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toolbar.setLayoutParams(params);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", true);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        editor.apply();

        Button check = v.findViewById(R.id.giftButton);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() == null) return;
                    SharedPreferences timePref = getActivity().getSharedPreferences("Time", 0);
                    int value = timePref.getInt("value", 0);
                    Toast.makeText(getActivity(), "Vous avez " + value + " coin(s).", Toast.LENGTH_SHORT).show();
            }
        });

        TextView ddlcText = v.findViewById(R.id.valueDdlc);
        TextView mgtText = v.findViewById(R.id.valueMgt);
        TextView zeldaText = v.findViewById(R.id.valueZelda);
        TextView ascunsText = v.findViewById(R.id.valueAscuns);
        TextView deltaText = v.findViewById(R.id.valueDelta);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Number", 0);
        int ddlcNumber = sharedPreferences.getInt("ddlc", 0);
        String ddlcString = String.valueOf(ddlcNumber);
        ddlcText.setText(ddlcString);

        int mgtNumber = sharedPreferences.getInt("mgt", 0);
        String mgtString = String.valueOf(mgtNumber);
        mgtText.setText(mgtString);

        int deltaNumber = sharedPreferences.getInt("deltarune", 0);
        String deltaString = String.valueOf(deltaNumber);
        deltaText.setText(deltaString);

        int zeldaNumber = sharedPreferences.getInt("zelda", 0);
        String zeldaString = String.valueOf(zeldaNumber);
        zeldaText.setText(zeldaString);

        int ascunsNumber = sharedPreferences.getInt("ascuns", 0);
        String ascunsString = String.valueOf(ascunsNumber);
        ascunsText.setText(ascunsString);

        return v;
    }
}
