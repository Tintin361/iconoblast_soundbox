package com.papple.iconoblast;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IcoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_ico, container, false);

        AppCompatImageView fcImage = v.findViewById(R.id.fbImageView);
        final AppCompatImageView twImage = v.findViewById(R.id.twImageView);
        AppCompatImageView tcImage = v.findViewById(R.id.tcImageView);
        final AppCompatImageView ytImage = v.findViewById(R.id.ytImageView);

        fcImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fb = "https://www.facebook.com/liconoclaste";
                Intent fbIntent = new Intent(Intent.ACTION_VIEW);
                fbIntent.setData(Uri.parse(fb));
                startActivity(fbIntent);
            }
        });

        twImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tw = "https://twitter.com/Iconokrew";
                Intent twIntent = new Intent(Intent.ACTION_VIEW);
                twIntent.setData(Uri.parse(tw));
                startActivity(twIntent);
            }
        });

        tcImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tc = "https://www.twitch.tv/iconoblastmissile";
                Intent tcIntent = new Intent(Intent.ACTION_VIEW);
                tcIntent.setData(Uri.parse(tc));
                startActivity(tcIntent);
            }
        });

        ytImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yt = "https://www.youtube.com/channel/UCq-TKBeO8hBMXfzZfJ2Ua4g";
                Intent ytIntent = new Intent(Intent.ACTION_VIEW);
                ytIntent.setData(Uri.parse(yt));
                startActivity(ytIntent);
            }
        });

        return v;
    }

}
