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

        final AppCompatImageView twImage = v.findViewById(R.id.twImageView);
        AppCompatImageView tcImage = v.findViewById(R.id.tcImageView);
        final AppCompatImageView ytImage = v.findViewById(R.id.ytImageView);
        AppCompatImageView igImage = v.findViewById(R.id.igImageView);
        AppCompatImageView discordImage = v.findViewById(R.id.discordImageView);
        AppCompatImageView IcoImage = v.findViewById(R.id.IcoImageView);
        AppCompatImageView etaImage = v.findViewById(R.id.EtaImageView);

        twImage.setOnClickListener(v1 -> {
            String tw = "https://twitter.com/Iconokrew";
            Intent twIntent = new Intent(Intent.ACTION_VIEW);
            twIntent.setData(Uri.parse(tw));
            startActivity(twIntent);
        });

        tcImage.setOnClickListener(v12 -> {
            String tc = "https://www.twitch.tv/iconoblastmissile";
            Intent tcIntent = new Intent(Intent.ACTION_VIEW);
            tcIntent.setData(Uri.parse(tc));
            startActivity(tcIntent);
        });

        ytImage.setOnClickListener(v13 -> {
            String yt = "https://www.youtube.com/channel/UCq-TKBeO8hBMXfzZfJ2Ua4g";
            Intent ytIntent = new Intent(Intent.ACTION_VIEW);
            ytIntent.setData(Uri.parse(yt));
            startActivity(ytIntent);
        });

        igImage.setOnClickListener(view -> {
            String ig = "https://www.instagram.com/iconoclaste_insta/";
            Intent igIntent = new Intent(Intent.ACTION_VIEW);
            igIntent.setData(Uri.parse(ig));
            startActivity(igIntent);
        });

        discordImage.setOnClickListener(view -> {
            String discord = "https://discordapp.com/invite/QhCsv3X";
            Intent discordIntent = new Intent(Intent.ACTION_VIEW);
            discordIntent.setData(Uri.parse(discord));
            startActivity(discordIntent);
        });

        IcoImage.setOnClickListener(view -> {
            String ico = "https://www.youtube.com/channel/UCeVpI1jEdMUfboWOtl_Bq6g";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });

        etaImage.setOnClickListener(view -> {
            String etagere = "https://www.youtube.com/channel/UCUbxzOacavHOAyLlHigrXFw";
            Intent etaIntent = new Intent(Intent.ACTION_VIEW);
            etaIntent.setData(Uri.parse(etagere));
            startActivity(etaIntent);
        });

        return v;
    }

}
