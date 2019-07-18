package com.papple.iconoblast;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class DeltaruneAdapter extends RecyclerView.Adapter<DeltaruneAdapter.ViewHolder> {

    private final List<Pair<String, String>> names = Arrays.asList(
            Pair.create("Guerriers Delta !!! (Ico et Étagère)", "1"),
            Pair.create("KRISEUH ! (Ico)", "2")
    );

    @Override
    public int getItemCount() { return names.size(); }

    @NonNull
    @Override
    public DeltaruneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeltaruneAdapter.ViewHolder holder, int position) {
        Pair<String, String> pair = names.get(position);
        holder.display(pair);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final Button name;

        Pair<String, String> currentPair;

        ViewHolder(final  View itemView) {
            super(itemView);

            name = (itemView.findViewById(R.id.buttonList));
        }

        void display(Pair<String, String> pair) {
            currentPair = pair;
            name.setText(pair.first);
        }

    }
}
