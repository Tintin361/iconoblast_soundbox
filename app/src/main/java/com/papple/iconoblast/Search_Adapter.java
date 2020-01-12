package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Search_Adapter extends RecyclerView.Adapter<Search_Adapter.SearchViewHolder> implements Filterable {
    private ArrayList<Search_Item_List> SearchList;
    private ArrayList<Search_Item_List> listFull;
    private OnItemClickListener sListener;
    private Context sContext;
    private View view;
    private int lastPosition = -1;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        sListener = listener;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        CardView searchCardView;
        ImageView searchImageView;
        TextView searchTextView;

        SearchViewHolder(View itemView) {
            super(itemView);
            searchCardView = itemView.findViewById(R.id.deltaruneCardView);
            searchImageView = itemView.findViewById(R.id.deltaruneImageView);
            searchTextView = itemView.findViewById(R.id.deltaruneTextView);

            itemView.setOnClickListener(v -> {
                if (sListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        sListener.onItemClick(v, position);
                    }
                }
            });
        }
    }

    Search_Adapter(ArrayList<Search_Item_List> exampleList) {
        SearchList = exampleList;
        listFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder SearchViewHolder, int position) {
        Search_Item_List currentItem = SearchList.get(position);

        SearchViewHolder.searchTextView.setText(currentItem.getSearchText());

        Picasso.get()
                .load(currentItem.getImageRessource())
                .into(SearchViewHolder.searchImageView);

        sContext = view.getContext();

        SharedPreferences settings = sContext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getSearchText()) {
                case "COUCOU LES COPAAAIIIINS !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(android.R.color.holo_orange_light)));
                    break;
                case "COUCOU C'EST NUMOUS, AVEC ADDICTIO !":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(android.R.color.holo_blue_light)));
                    break;
                case "C'est parce que j'veux ken !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "HAHA !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green3)));
                    break;
                case "Étagère_sound.ogg":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green4)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue1)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue2)));
                    break;
                case "SUPER !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue3)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue4)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue5)));
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.darkBlue)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.purple)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.purple2)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.pink1)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.pink2)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.red2)));
                    break;
                case "Iconoclaste_sound.ogg":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.red3)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.orange2)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green3)));
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green4)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue1)));
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue2)));
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue3)));
                    break;
                case "C'est un immense branleur ! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green3)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green4)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue1)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue2)));
                    break;
                case "Guerriers Delta !!! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue3)));
                    break;
                case "KRISEUH ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.blue4)));
                    break;
                case "Non, et tu t'amuse !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "ZELDA !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Chanson Ico et Étagère":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.green3)));
                    break;
                case "SALUUUUUUT !!!!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.Green2)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getSearchText()) {
                case "COUCOU LES COPAAAIIIINS !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(android.R.color.holo_orange_dark)));
                    break;
                case "COUCOU C'EST NUMOUS, AVEC ADDICTIO !":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(android.R.color.holo_blue_light)));
                    break;
                case "C'est parce que j'veux ken !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "HAHA !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Étagère_sound.ogg":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen)));
                    break;
                case "SUPER !!! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen2)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen3)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen4)));
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dYellow)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dOrange)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dRed)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dRed2)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple3)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "Iconoclaste_sound.ogg":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen)));
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen2)));
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen3)));
                    break;
                case "C'est un immense branleur ! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "Maaaaiiis, où c'est qui vont aller se masturber ? (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Lui, il fait des doigts d'honneur devant les portes ! (Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Mais c'est dégueulasse Addictio... (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Mais ta gueule !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Tu vois là, on est baisés ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "TOUCH MY COCK !!! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen)));
                    break;
                case "Guerriers Delta !!! (Ico et Étagère)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "KRISEUH ! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "Non, et tu t'amuse !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Qu'est-ce que j'aimerais ... (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "ZELDA !!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "Chanson Ico et Étagère":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "SALUUUUUUT !!!!! (Ico)":
                    SearchViewHolder.searchCardView.setCardBackgroundColor(ColorStateList.valueOf(SearchViewHolder.searchCardView.getResources().getColor(R.color.dGreen)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(sContext,
                R.anim.up_from_bottom);
        SearchViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
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
            List<Search_Item_List> filtredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filtredList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Search_Item_List item : listFull) {
                    if (item.getSearchText().toLowerCase().contains(filterPattern)) {
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
