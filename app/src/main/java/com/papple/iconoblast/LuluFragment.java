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

public class LuluFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lulu, container, false);

        AppCompatImageView ytI = v.findViewById(R.id.ytImageView);
        AppCompatImageView twI = v.findViewById(R.id.twImageView);
        AppCompatImageView tcI = v.findViewById(R.id.tcImageView);

        ytI.setOnClickListener(view -> {
            String yt = "https://www.youtube.com/channel/UCZ4M_696a_LCdyvtMYm8vCg";
            Intent ytIntent = new Intent(Intent.ACTION_VIEW);
            ytIntent.setData(Uri.parse(yt));
            startActivity(ytIntent);
        });

        twI.setOnClickListener(view -> {
            String tw = "https://twitter.com/DarakaX";
            Intent twIntent = new Intent(Intent.ACTION_VIEW);
            twIntent.setData(Uri.parse(tw));
            startActivity(twIntent);
        });

        tcI.setOnClickListener(view -> {
            String tc = "https://www.twitch.tv/darakax";
            Intent tcIntent = new Intent(Intent.ACTION_VIEW);
            tcIntent.setData(Uri.parse(tc));
            startActivity(tcIntent);
        });

        return v;
    }

}
