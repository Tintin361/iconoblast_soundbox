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

public class Ascuns_Adapter extends RecyclerView.Adapter<Ascuns_Adapter.ascunsViewHolder> {
    private ArrayList<Ascuns_Item_List> mAscunsList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context acontext;
    private Adapter aAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class ascunsViewHolder extends RecyclerView.ViewHolder {
        CardView ascunsCardView;
        ImageView ascunsImageView;
        TextView ascunsTextView;

        ascunsViewHolder(View itemView) {
            super(itemView);
            ascunsCardView = itemView.findViewById(R.id.deltaruneCardView);
            ascunsImageView = itemView.findViewById(R.id.deltaruneImageView);
            ascunsTextView = itemView.findViewById(R.id.deltaruneTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    Ascuns_Adapter(ArrayList<Ascuns_Item_List> exampleList) {
        mAscunsList = exampleList;
    }

    @NonNull
    @Override
    public ascunsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new ascunsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ascunsViewHolder ascunsViewHolder, int position) {
        final Ascuns_Item_List currentItem = mAscunsList.get(position);

        ascunsViewHolder.ascunsTextView.setText(currentItem.getAscunsText());

        Picasso.get()
                .load(currentItem.getAscunsImageRessource())
                .into(ascunsViewHolder.ascunsImageView);

        acontext = view.getContext();

        SharedPreferences settings = acontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getAscunsText()) {
                case "SALUUUUUUT !!!!! (Ico)":
                    ascunsViewHolder.ascunsCardView.setCardBackgroundColor(ColorStateList.valueOf(ascunsViewHolder.ascunsCardView.getResources().getColor(R.color.Green2)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getAscunsText()) {
                case "SALUUUUUUT !!!!! (Ico)":
                    ascunsViewHolder.ascunsCardView.setCardBackgroundColor(ColorStateList.valueOf(ascunsViewHolder.ascunsCardView.getResources().getColor(R.color.dGreen)));
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
        return mAscunsList.size();
    }
}
