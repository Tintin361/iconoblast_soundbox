package com.papple.iconoblast;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Deltarune_Adapter extends RecyclerView.Adapter<Deltarune_Adapter.deltaruneViewHolder> {
    private ArrayList<Deltarune_Item_List> mDeltaruneList;
    private OnItemClickListener mListener;


    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class deltaruneViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        deltaruneViewHolder(View itemView) {
            super(itemView);
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new deltaruneViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull deltaruneViewHolder deltaruneViewHolder, int position) {
        Deltarune_Item_List currentItem = mDeltaruneList.get(position);

        deltaruneViewHolder.mImageView.setImageResource(currentItem.getImageRessource());
        deltaruneViewHolder.mTextView.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return mDeltaruneList.size();
    }


}
