package com.papple.iconoblast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

        final ImageView fcImage = v.findViewById(R.id.fbImageView);
        final ImageView twImage = v.findViewById(R.id.twImageView);
        final ImageView igImage = v.findViewById(R.id.igImageView);
        final ImageView ytImage = v.findViewById(R.id.ytImageView);
        final ImageView diImage = v.findViewById(R.id.diImageView);

        fcImage.setOnClickListener(v1 -> {
            String fb = "https://www.facebook.com/tintin.lofet";
            Intent fbIntent = new Intent(Intent.ACTION_VIEW);
            fbIntent.setData(Uri.parse(fb));
            startActivity(fbIntent);
        });

        twImage.setOnClickListener(v12 -> {
            String tw = "https://twitter.com/Tintin361YT";
            Intent twIntent = new Intent(Intent.ACTION_VIEW);
            twIntent.setData(Uri.parse(tw));
            startActivity(twIntent);
        });

        igImage.setOnClickListener(v13 -> {
            String ig = "https://www.instagram.com/tintin361/";
            Intent igIntent = new Intent(Intent.ACTION_VIEW);
            igIntent.setData(Uri.parse(ig));
            startActivity(igIntent);
        });

        ytImage.setOnClickListener(v14 -> {
            String yt = "https://www.youtube.com/c/tintin361";
            Intent ytIntent = new Intent(Intent.ACTION_VIEW);
            ytIntent.setData(Uri.parse(yt));
            startActivity(ytIntent);
        });

        diImage.setOnClickListener(v15 -> {
            String dis = "https://www.discord.gg/w9x3s8x";
            Intent disIntent = new Intent(Intent.ACTION_VIEW);
            disIntent.setData(Uri.parse(dis));
            startActivity(disIntent);
        });

        return v;
    }

}
