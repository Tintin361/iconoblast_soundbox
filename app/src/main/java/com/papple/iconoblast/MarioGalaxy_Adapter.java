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

public class MarioGalaxy_Adapter extends RecyclerView.Adapter<MarioGalaxy_Adapter.marioGalaxyViewHolder> {
    private ArrayList<MarioGalaxy_Item_List> mMarioGalaxyList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context gcontext;
    private Adapter gAdapter2;
    private int lastPosition = -1;
    private View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class marioGalaxyViewHolder extends RecyclerView.ViewHolder {
        CardView marioGalaxyCardView;
        ImageView marioGalaxyImageView;
        TextView marioGalaxyTextView;

        marioGalaxyViewHolder(View itemView) {
            super(itemView);
            marioGalaxyCardView = itemView.findViewById(R.id.deltaruneCardView);
            marioGalaxyImageView = itemView.findViewById(R.id.deltaruneImageView);
            marioGalaxyTextView = itemView.findViewById(R.id.deltaruneTextView);

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

    MarioGalaxy_Adapter(ArrayList<MarioGalaxy_Item_List> exampleList) {
        mMarioGalaxyList = exampleList;
    }

    @NonNull
    @Override
    public marioGalaxyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new marioGalaxyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final marioGalaxyViewHolder marioGalaxyViewHolder, int position) {
        final MarioGalaxy_Item_List currentItem = mMarioGalaxyList.get(position);

        marioGalaxyViewHolder.marioGalaxyTextView.setText(currentItem.getMarioGalaxyText());

        Picasso.get()
                .load(currentItem.getMarioGalaxyImageRessource())
                .into(marioGalaxyViewHolder.marioGalaxyImageView);

        gcontext = view.getContext();

        SharedPreferences settings = gcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getMarioGalaxyText()) {
                case "Ça rime avec... (Étagère.exe)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.pink1)));
                    break;
                case "Pute, pute... (Étagère)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.pink2)));
                    break;
                case "C'est parti ! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.red2)));
                    break;
                case "I'm cumming !!! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.red3)));
                    break;
                case "NOOOOOOOOOON ! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.orange2)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getMarioGalaxyText()) {
                case "Ça rime avec... (Étagère.exe)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.dYellow)));
                    break;
                case "Pute, pute... (Étagère)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.dOrange)));
                    break;
                case "C'est parti ! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.dRed)));
                    break;
                case "I'm cumming !!! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.dRed2)));
                    break;
                case "NOOOOOOOOOON ! (Ico)":
                    marioGalaxyViewHolder.marioGalaxyCardView.setCardBackgroundColor(ColorStateList.valueOf(marioGalaxyViewHolder.marioGalaxyCardView.getResources().getColor(R.color.dPurple3)));
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
        return mMarioGalaxyList.size();
    }
}
