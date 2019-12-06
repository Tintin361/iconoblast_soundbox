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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Mgt_Adapter extends RecyclerView.Adapter<Mgt_Adapter.mgtViewHolder> {
    private ArrayList<Mgt_Item_List> mMgtList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context mcontext;
    private Adapter mAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class mgtViewHolder extends RecyclerView.ViewHolder {
        CardView mgtCardView;
        ImageView mgtImageView;
        TextView mgtTextView;

        mgtViewHolder(View itemView) {
            super(itemView);
            mgtCardView = itemView.findViewById(R.id.deltaruneCardView);
            mgtImageView = itemView.findViewById(R.id.deltaruneImageView);
            mgtTextView = itemView.findViewById(R.id.deltaruneTextView);

            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(v, position);
                    }
                }
            });
        }
    }

    Mgt_Adapter(ArrayList<Mgt_Item_List> exampleList) {
        mMgtList = exampleList;
    }

    @NonNull
    @Override
    public mgtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new mgtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final mgtViewHolder mgtViewHolder, int position) {
        final Mgt_Item_List currentItem = mMgtList.get(position);

        mgtViewHolder.mgtTextView.setText(currentItem.getMgtText());

        Picasso.get()
                .load(currentItem.getMgtImageRessource())
                .into(mgtViewHolder.mgtImageView);

        mcontext = view.getContext();

        SharedPreferences settings = mcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getMgtText()) {
                case "C'est un immense branleur ! (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.green3)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.green4)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.blue1)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.blue2)));
                    break;

            }

        } else if (answerB) {
            switch (currentItem.getMgtText()) {
                case "C'est un immense branleur ! (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    mgtViewHolder.mgtCardView.setCardBackgroundColor(ColorStateList.valueOf(mgtViewHolder.mgtCardView.getResources().getColor(R.color.dGreen)));
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
        return mMgtList.size();
    }
}
