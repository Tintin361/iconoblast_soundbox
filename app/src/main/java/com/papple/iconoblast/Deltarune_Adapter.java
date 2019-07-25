package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Deltarune_Adapter extends RecyclerView.Adapter<Deltarune_Adapter.deltaruneViewHolder> {
    private ArrayList<Deltarune_Item_List> mDeltaruneList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context context;
    private Adapter mAdapter;
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

        deltaruneViewHolder.mImageView.setImageResource(currentItem.getImageRessource());
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
    }

    @Override
    public int getItemCount() {
        return mDeltaruneList.size();
    }

}