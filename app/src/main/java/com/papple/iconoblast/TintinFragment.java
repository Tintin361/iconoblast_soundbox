package com.papple.iconoblast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.net.Uri;

public class TintinFragment extends Fragment {

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_tintin, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);

        CardView cardView = v.findViewById(R.id.cardView1);
        CardView cardView2 = v.findViewById(R.id.cardView2);
        CardView cardView3 = v.findViewById(R.id.cardView3);

        final ImageView fcImage = v.findViewById(R.id.fbImageView);
        final ImageView twImage = v.findViewById(R.id.twImageView);
        final ImageView igImage = v.findViewById(R.id.igImageView);
        final ImageView ytImage = v.findViewById(R.id.ytImageView);
        final ImageView diImage = v.findViewById(R.id.diImageView);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
            cardView2.setCardBackgroundColor(getResources().getColor(android.R.color.white));
            cardView3.setCardBackgroundColor(getResources().getColor(android.R.color.white));

        } else if (answerB) {
            cardView.setCardBackgroundColor(getResources().getColor(R.color.cardViewColor));
            cardView2.setCardBackgroundColor(getResources().getColor(R.color.cardViewColor));
            cardView3.setCardBackgroundColor(getResources().getColor(R.color.cardViewColor));
        }

        fcImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fb = "https://www.facebook.com/tintin.lofet";
                Intent fbIntent = new Intent(Intent.ACTION_VIEW);
                fbIntent.setData(Uri.parse(fb));
                startActivity(fbIntent);
            }
        });

        twImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tw = "https://twitter.com/Tintin361YT";
                Intent twIntent = new Intent(Intent.ACTION_VIEW);
                twIntent.setData(Uri.parse(tw));
                startActivity(twIntent);
            }
        });

        igImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ig = "https://www.instagram.com/tintin361/";
                Intent igIntent = new Intent(Intent.ACTION_VIEW);
                igIntent.setData(Uri.parse(ig));
                startActivity(igIntent);
            }
        });

        ytImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yt = "https://www.youtube.com/c/tintin361";
                Intent ytIntent = new Intent(Intent.ACTION_VIEW);
                ytIntent.setData(Uri.parse(yt));
                startActivity(ytIntent);
            }
        });

        diImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dis = "https://www.discord.gg/w9x3s8x";
                Intent disIntent = new Intent(Intent.ACTION_VIEW);
                disIntent.setData(Uri.parse(dis));
                startActivity(disIntent);
            }
        });

        return v;
    }

}
