package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class Search_Adapter_List extends RecyclerView.Adapter<Search_Adapter_List.SearchViewHolder> implements Filterable {
    private ArrayList<Search_Item_List_ListVersion> SearchList;
    private ArrayList<Search_Item_List_ListVersion> listFull;
    private RecyclerView sRecyclerView;
    private OnItemClickListener sListener;
    private Context sContext;
    private Adapter sAdapter;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        sListener = listener;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        Button sButton;

        SearchViewHolder(View itemView) {
            super(itemView);
            sButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            sListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    Search_Adapter_List(ArrayList<Search_Item_List_ListVersion> exampleList) {
        SearchList = exampleList;
        listFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search_listversion, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder SearchViewHolder, int position) {
        Search_Item_List_ListVersion currentItem = SearchList.get(position);

        SearchViewHolder.sButton.setText(currentItem.getText());

        sContext = view.getContext();

        SharedPreferences settings = sContext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (position == 0) {
            if (answerA) {
            } else if (answerB) {
            } else {
            }

        } else if (position == 1) {
            if (answerA) {
            } else if (answerB) {
            } else {
            }
        }
    }

    @Override
    public int getItemCount() {
        return SearchList.size();
    }

    @Override
    public Filter getFilter() {
        return sFilter;
    }

    private Filter sFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Search_Item_List_ListVersion> filtredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filtredList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Search_Item_List_ListVersion item : listFull) {
                    if (item.getText().toLowerCase().contains(filterPattern)) {
                        filtredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filtredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            SearchList.clear();
            SearchList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}
