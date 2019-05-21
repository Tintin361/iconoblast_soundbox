package com.papple.iconoblast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

        final ImageView fcImage = v.findViewById(R.id.fbImageView);
        final ImageView twImage = v.findViewById(R.id.twImageView);
        final ImageView igImage = v.findViewById(R.id.igImageView);
        final ImageView ytImage = v.findViewById(R.id.ytImageView);

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

        return v;
    }

}
