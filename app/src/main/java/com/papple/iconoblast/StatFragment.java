package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class StatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_stat, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag", false);
        editor.putBoolean("sFrag", true);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", false);
        editor.putBoolean("asFrag", false);

        editor.apply();


        Button check = v.findViewById(R.id.giftButton);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeDay();
            }
        });

        Button point = v.findViewById(R.id.pointButton);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences timePref = getActivity().getSharedPreferences("Time", 0);
                int value = timePref.getInt("value", 0);
                Toast.makeText(getActivity(), "Vous avez " + value + " coin(s).", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    public void timeDay() {
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        SharedPreferences timePref = getActivity().getSharedPreferences("Time", 0);
        int lastDay = timePref.getInt("day",0);

        if (lastDay != currentDay){
            SharedPreferences.Editor editor = timePref.edit();
            editor.putInt("day", currentDay);
            editor.apply();

            // Code
            int value = timePref.getInt("value", 0);
            value = value + 1;
            editor.putInt("value", value);
            editor.apply();
        } else {
            Toast.makeText(getActivity(), "Vous avez déjà fait un CHECK IN !", Toast.LENGTH_SHORT).show();
        }
    }
}
