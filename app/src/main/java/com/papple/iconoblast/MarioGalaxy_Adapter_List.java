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

public class MarioGalaxy_Adapter_List extends RecyclerView.Adapter<MarioGalaxy_Adapter_List.marioGalaxyViewHolder> {
    private ArrayList<MarioGalaxy_Item_List_ListVersion> marioGalaxyList;
    private RecyclerView marioGalaxyRecyclerView;
    private OnItemClickListener marioGalaxyListener;
    private Context gcontext;
    private Adapter marioGalaxyAdapter;
    private int lastPosition = -1;
    private View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        marioGalaxyListener = listener;
    }

    class marioGalaxyViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        marioGalaxyViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(v -> {
                if (marioGalaxyListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        marioGalaxyListener.onItemClick(v, position);
                    }
                }
            });
        }
    }

    MarioGalaxy_Adapter_List(ArrayList<MarioGalaxy_Item_List_ListVersion> exampleList) {
        marioGalaxyList = exampleList;
    }

    @NonNull
    @Override
    public marioGalaxyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new marioGalaxyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull marioGalaxyViewHolder marioGalaxyViewHolder, int position) {
        MarioGalaxy_Item_List_ListVersion currentItem = marioGalaxyList.get(position);

        marioGalaxyViewHolder.mButton.setText(currentItem.getText());

        gcontext = view.getContext();

        SharedPreferences settings = gcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getText()) {
                case "Ça rime avec... (Étagère.exe)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.pink1)));
                    break;
                case "Pute, pute... (Étagère)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.pink2)));
                    break;
                case "C'est parti ! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.red2)));
                    break;
                case "I'm cumming !!! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.red3)));
                    break;
                case "NOOOOOOOOOON ! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.orange2)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getText()) {
                case "Ça rime avec... (Étagère.exe)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.dYellow)));
                    break;
                case "Pute, pute... (Étagère)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.dOrange)));
                    break;
                case "C'est parti ! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.dRed)));
                    break;
                case "I'm cumming !!! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.dRed2)));
                    break;
                case "NOOOOOOOOOON ! (Ico)":
                    marioGalaxyViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(marioGalaxyViewHolder.mButton.getResources().getColor(R.color.dPurple3)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(gcontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        marioGalaxyViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return marioGalaxyList.size();
    }

}

