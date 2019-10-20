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

public class Ascuns_Adapter_List extends RecyclerView.Adapter<Ascuns_Adapter_List.ascunsViewHolder> {
    private ArrayList<Ascuns_Item_List_ListVersion> ascunsList;
    private RecyclerView ascunsRecyclerView;
    private OnItemClickListener ascunsListener;
    private Context acontext;
    private Adapter ascunsAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        ascunsListener = listener;
    }

    class ascunsViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        ascunsViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ascunsListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            ascunsListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    Ascuns_Adapter_List(ArrayList<Ascuns_Item_List_ListVersion> exampleList) {
        ascunsList = exampleList;
    }

    @NonNull
    @Override
    public ascunsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new ascunsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ascunsViewHolder ascunsViewHolder, int position) {
        Ascuns_Item_List_ListVersion currentItem = ascunsList.get(position);

        ascunsViewHolder.mButton.setText(currentItem.getText());

        acontext = view.getContext();

        SharedPreferences settings = acontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getText()) {
                case "SALUUUUUUT !!!!! (Ico)":
                    ascunsViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ascunsViewHolder.mButton.getResources().getColor(R.color.Green2)));
                    break;
            }
        } else if (answerB) {
            switch (currentItem.getText()) {
                case "SALUUUUUUT !!!!! (Ico)":
                    ascunsViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ascunsViewHolder.mButton.getResources().getColor(R.color.dGreen)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(acontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        ascunsViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return ascunsList.size();
    }

}

