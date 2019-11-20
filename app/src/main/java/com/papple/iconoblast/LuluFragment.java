package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LuluFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lulu, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        CardView cardView = v.findViewById(R.id.luluCardView1);
        CardView cardView2 = v.findViewById(R.id.luluCardView2);

        if (answerA) {
            cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
            cardView2.setCardBackgroundColor(getResources().getColor(android.R.color.white));

        } else if (answerB) {
            cardView.setCardBackgroundColor(getResources().getColor(R.color.cardViewColor));
            cardView2.setCardBackgroundColor(getResources().getColor(R.color.cardViewColor));
        }

        return v;
    }

}
