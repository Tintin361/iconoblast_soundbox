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

import com.makeramen.roundedimageview.RoundedImageView;

public class IcoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ico, container, false);

        // Iconoblast !
        RoundedImageView vodImageView = v.findViewById(R.id.VodImageView);
        AppCompatImageView twBlastImageView = v.findViewById(R.id.twBlastImageView);
        AppCompatImageView tcBlastImageView = v.findViewById(R.id.tcBlastImageView);
        AppCompatImageView discordBlastImageView = v.findViewById(R.id.discordBlastImageView);
        AppCompatImageView ytBlastImageView = v.findViewById(R.id.ytBlastImageView);

        vodImageView.setOnClickListener(view -> {
            String vod = "https://www.youtube.com/channel/UCcqjrGW2JgY8-ka7rksogIA";
            Intent vodIntent = new Intent(Intent.ACTION_VIEW);
            vodIntent.setData(Uri.parse(vod));
            startActivity(vodIntent);
        });

        twBlastImageView.setOnClickListener(v1 -> {
            String tw = "https://twitter.com/Iconokrew";
            Intent twIntent = new Intent(Intent.ACTION_VIEW);
            twIntent.setData(Uri.parse(tw));
            startActivity(twIntent);
        });

        tcBlastImageView.setOnClickListener(v2 -> {
            String tc = "https://www.twitch.tv/iconoblastmissile";
            Intent tcIntent = new Intent(Intent.ACTION_VIEW);
            tcIntent.setData(Uri.parse(tc));
            startActivity(tcIntent);
        });

        discordBlastImageView.setOnClickListener(v3 -> {
            String discord = "https://discordapp.com/invite/QhCsv3X";
            Intent discordIntent = new Intent(Intent.ACTION_VIEW);
            discordIntent.setData(Uri.parse(discord));
            startActivity(discordIntent);
        });

        ytBlastImageView.setOnClickListener(v4 -> {
            String yt = "https://www.youtube.com/channel/UCq-TKBeO8hBMXfzZfJ2Ua4g";
            Intent ytIntent = new Intent(Intent.ACTION_VIEW);
            ytIntent.setData(Uri.parse(yt));
            startActivity(ytIntent);
        });


        // Iconoclaste
        AppCompatImageView ytIco = v.findViewById(R.id.ytIcoImageView);
        AppCompatImageView twIco = v.findViewById(R.id.twIcoImageView);
        AppCompatImageView igIco = v.findViewById(R.id.igIcoImageView);
        AppCompatImageView fbIco = v.findViewById(R.id.fbIcoImageView);
        AppCompatImageView snapIco = v.findViewById(R.id.spIcoImageView);

        ytIco.setOnClickListener(v5 -> {
            String ico = "https://www.youtube.com/channel/UCeVpI1jEdMUfboWOtl_Bq6g";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });

        twIco.setOnClickListener(v5 -> {
            String ico = "https://twitter.com/IconoTweet";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });

        igIco.setOnClickListener(v6 -> {
            String ico = "https://www.instagram.com/iconoclaste_insta/?hl=fr";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });

        fbIco.setOnClickListener(v7 -> {
            String ico = "https://www.facebook.com/liconoclaste/";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });

        snapIco.setOnClickListener(v8 -> {
            String ico = "https://www.snapchat.com/add/iconotweet";
            Intent icoIntent = new Intent(Intent.ACTION_VIEW);
            icoIntent.setData(Uri.parse(ico));
            startActivity(icoIntent);
        });


        // Etagère
        AppCompatImageView discordEta = v.findViewById(R.id.discordEtaImageView);
        AppCompatImageView ytEta = v.findViewById(R.id.ytEtaImageView);
        AppCompatImageView twEta = v.findViewById(R.id.twEtaImageView);

        discordEta.setOnClickListener(view -> {
            String eta = "https://discord.gg/zzBvR7N";
            Intent etaIntent = new Intent(Intent.ACTION_VIEW);
            etaIntent.setData(Uri.parse(eta));
            startActivity(etaIntent);
        });

        ytEta.setOnClickListener(view -> {
            String eta = "https://www.youtube.com/channel/UCUbxzOacavHOAyLlHigrXFw";
            Intent etaIntent = new Intent(Intent.ACTION_VIEW);
            etaIntent.setData(Uri.parse(eta));
            startActivity(etaIntent);
        });

        twEta.setOnClickListener(view -> {
            String eta = "https://twitter.com/etageregentil?lang=fr";
            Intent etaIntent = new Intent(Intent.ACTION_VIEW);
            etaIntent.setData(Uri.parse(eta));
            startActivity(etaIntent);
        });

        return v;
    }

}
