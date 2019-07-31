package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Deltarune_Adapter extends RecyclerView.Adapter<Deltarune_Adapter.deltaruneViewHolder> {
    private ArrayList<Deltarune_Item_List> mDeltaruneList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context context;
    private Adapter mAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class deltaruneViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        ImageView mImageView;
        TextView mTextView;

        deltaruneViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.deltaruneCardView);
            mImageView = itemView.findViewById(R.id.deltaruneImageView);
            mTextView = itemView.findViewById(R.id.deltaruneTextView);

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

    Deltarune_Adapter(ArrayList<Deltarune_Item_List> exampleList) {
        mDeltaruneList = exampleList;
    }

    @NonNull
    @Override
    public deltaruneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new deltaruneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull deltaruneViewHolder deltaruneViewHolder, int position) {
        Deltarune_Item_List currentItem = mDeltaruneList.get(position);

        Picasso.get()
                .load(currentItem.getImageRessource())
                .into(deltaruneViewHolder.mImageView);
        deltaruneViewHolder.mTextView.setText(currentItem.getText());

        context = view.getContext();

        SharedPreferences settings = context.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (position == 0) {
            if (answerA) {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.blue3));
            } else if (answerB) {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.dBlue3));
            } else {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.blue3));
            }

        } else if (position == 1) {
            if (answerA) {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.blue4));
            } else if (answerB) {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.dBlue4));
            } else {
                deltaruneViewHolder.mCardView.setCardBackgroundColor(deltaruneViewHolder.itemView.getResources().getColor(R.color.blue4));
            }
        }

        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        deltaruneViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return mDeltaruneList.size();
    }

}
