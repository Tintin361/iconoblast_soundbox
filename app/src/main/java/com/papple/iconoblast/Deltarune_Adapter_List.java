package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class Deltarune_Adapter_List extends RecyclerView.Adapter<Deltarune_Adapter_List.deltaruneViewHolder> {
    private ArrayList<Deltarune_Item_List_ListVersion> mDeltaruneList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context context;
    private Adapter nAdapter;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class deltaruneViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        deltaruneViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

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

    Deltarune_Adapter_List(ArrayList<Deltarune_Item_List_ListVersion> exampleList) {
        mDeltaruneList = exampleList;
    }

    @NonNull
    @Override
    public deltaruneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new deltaruneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull deltaruneViewHolder deltaruneViewHolder, int position) {
        Deltarune_Item_List_ListVersion currentItem = mDeltaruneList.get(position);

        deltaruneViewHolder.mButton.setText(currentItem.getText());

        context = view.getContext();

        SharedPreferences settings = context.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (position == 0) {
            if (answerA) {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.blue3));
            } else if (answerB) {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.dBlue3));
            } else {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.blue3));
            }

        } else if (position == 1) {
            if (answerA) {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.blue4));
            } else if (answerB) {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.dBlue4));
            } else {
                deltaruneViewHolder.mButton.setSupportBackgroundTintList(deltaruneViewHolder.itemView.getResources().getColorStateList(R.color.blue4));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDeltaruneList.size();
    }

}
