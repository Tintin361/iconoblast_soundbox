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

public class Zelda_Adapter extends RecyclerView.Adapter<Zelda_Adapter.zeldaViewHolder> {
    private ArrayList<Zelda_Item_List> mZeldaList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context zcontext;
    private Adapter zAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class zeldaViewHolder extends RecyclerView.ViewHolder {
        CardView zeldaCardView;
        ImageView zeldaImageView;
        TextView zeldaTextView;

        zeldaViewHolder(View itemView) {
            super(itemView);
            zeldaCardView = itemView.findViewById(R.id.deltaruneCardView);
            zeldaImageView = itemView.findViewById(R.id.deltaruneImageView);
            zeldaTextView = itemView.findViewById(R.id.deltaruneTextView);

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

    Zelda_Adapter(ArrayList<Zelda_Item_List> exampleList) {
        mZeldaList = exampleList;
    }

    @NonNull
    @Override
    public zeldaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new zeldaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final zeldaViewHolder zeldaViewHolder, int position) {
        final Zelda_Item_List currentItem = mZeldaList.get(position);

        zeldaViewHolder.zeldaTextView.setText(currentItem.getZeldaText());

        Picasso.get()
                .load(currentItem.getZeldaImageRessource())
                .into(zeldaViewHolder.zeldaImageView);

        zcontext = view.getContext();

        SharedPreferences settings = zcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getZeldaText()) {
                case "Non, et tu t'amuse !!! (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "ZELDA !!! (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Chanson Ico et Étagère":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.green3)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getZeldaText()) {
                case "Non, et tu t'amuse !!! (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "ZELDA !!! (Ico)":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Chanson Ico et Étagère":
                    zeldaViewHolder.zeldaCardView.setCardBackgroundColor(ColorStateList.valueOf(zeldaViewHolder.zeldaCardView.getResources().getColor(R.color.dBlue4)));
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
        return mZeldaList.size();
    }
}
