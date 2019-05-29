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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class StatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.fragment_stat, container, false);

        if(getActivity() == null) return v;

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

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Number", 0);
        int ddlcNumber = sharedPreferences.getInt("ddlc", 0);
        String ddlcString = String.valueOf(ddlcNumber);
        ddlcText.setText(ddlcString);

        int mgtNumber = sharedPreferences.getInt("mgt", 0);
        String mgtString = String.valueOf(mgtNumber);
        mgtText.setText(mgtString);

        int zeldaNumber = sharedPreferences.getInt("zelda", 0);
        String zeldaString = String.valueOf(zeldaNumber);
        zeldaText.setText(zeldaString);

        int ascunsNumber = sharedPreferences.getInt("ascuns", 0);
        String ascunsString = String.valueOf(ascunsNumber);
        ascunsText.setText(ascunsString);

        final Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);

                        if(getActivity() == null) return;

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                update();
                                colorChange();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        return v;
    }

    public void update() {
        Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);

        hours = 24 - hours;
        minutes = 60 - minutes;
        seconds = 60 - seconds;

        String heure = String.valueOf(hours);
        String minute = String.valueOf(minutes);
        String seconde = String.valueOf(seconds);

        if (hours < 10) {
            heure = "0" + hours;

        } if (minutes < 10) {
            minute = "0" + minutes;

        } if (seconds < 10) {
            seconde = "0" + seconds;
        }


        String string = heure + ":" + minute + ":" + seconde;

        if(getActivity() == null)
            return;

        TextView textView = getActivity().findViewById(R.id.timeTextView);
        textView.setText(string);
    }

    public void timeDay() {

        if (getActivity() == null) {
            return;
        }

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
        }
    }

    public void colorChange() {

        if(getActivity() == null)
            return;

        Button check = getActivity().findViewById(R.id.giftButton);

        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        SharedPreferences timePref = getActivity().getSharedPreferences("Time", 0);
        int lastDay = timePref.getInt("day",0);

        if (lastDay != currentDay){
            check.setTextColor(getResources().getColor(R.color.dGreen));
        } else {
            check.setTextColor(getResources().getColor(R.color.white));
        }
    }

}
