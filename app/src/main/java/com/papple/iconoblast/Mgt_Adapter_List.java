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

public class Mgt_Adapter_List extends RecyclerView.Adapter<Mgt_Adapter_List.mgtViewHolder> {
    private ArrayList<Mgt_Item_List_ListVersion> mgtList;
    private RecyclerView mgtRecyclerView;
    private OnItemClickListener mgtListener;
    private Context mcontext;
    private Adapter mgtAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mgtListener = listener;
    }

    class mgtViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        mgtViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(v -> {
                if (mgtListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mgtListener.onItemClick(v, position);
                    }
                }
            });
        }
    }

    Mgt_Adapter_List(ArrayList<Mgt_Item_List_ListVersion> exampleList) {
        mgtList = exampleList;
    }

    @NonNull
    @Override
    public mgtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new mgtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mgtViewHolder mgtViewHolder, int position) {
        Mgt_Item_List_ListVersion currentItem = mgtList.get(position);

        mgtViewHolder.mButton.setText(currentItem.getText());

        mcontext = view.getContext();

        SharedPreferences settings = mcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getText()) {
                case "C'est un immense branleur ! (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.Red1)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.orange1)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.yellow1)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.green3)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.green4)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.blue1)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.blue2)));
                    break;
            }
        } else if (answerB) {
            switch (currentItem.getText()) {
                case "C'est un immense branleur ! (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dPurple)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dBlue)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dBlue4)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    mgtViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(mgtViewHolder.mButton.getResources().getColor(R.color.dGreen)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(mcontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        mgtViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return mgtList.size();
    }

}

