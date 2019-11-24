package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Zelda_Adapter_List extends RecyclerView.Adapter<Zelda_Adapter_List.zeldaViewHolder> {
    private ArrayList<Zelda_Item_List_ListVersion> zeldaList;
    private RecyclerView zeldaRecyclerView;
    private OnItemClickListener zeldaListener;
    private Context zcontext;
    private Adapter zeldaAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        zeldaListener = listener;
    }

    class zeldaViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        zeldaViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (zeldaListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            zeldaListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    Zelda_Adapter_List(ArrayList<Zelda_Item_List_ListVersion> exampleList) {
        zeldaList = exampleList;
    }

    @NonNull
    @Override
    public zeldaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new zeldaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull zeldaViewHolder zeldaViewHolder, int position) {
        Zelda_Item_List_ListVersion currentItem = zeldaList.get(position);

        zeldaViewHolder.mButton.setText(currentItem.getText());

        zcontext = view.getContext();

        SharedPreferences settings = zcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getText()) {
                case "Non, et tu t'amuse !!! (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.Red1)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.orange1)));
                    break;
                case "ZELDA !!! (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.yellow1)));
                    break;
                case "Chanson Ico et Étagère":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.green3)));
                    break;
            }
        } else if (answerB) {
            switch (currentItem.getText()) {
                case "Non, et tu t'amuse !!! (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.dBlue)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.dBlue2)));
                    break;
                case "ZELDA !!! (Ico)":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Chanson Ico et Étagère":
                    zeldaViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(zeldaViewHolder.mButton.getResources().getColor(R.color.dBlue4)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(zcontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        zeldaViewHolder.itemView.startAnimation(animation);
        lastPosition = position;

    }

    @Override
    public int getItemCount() {
        return zeldaList.size();
    }
}

