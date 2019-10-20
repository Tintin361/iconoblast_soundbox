package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
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

public class Ddlc_Adapter extends RecyclerView.Adapter<Ddlc_Adapter.ddlcViewHolder> {
    private ArrayList<Ddlc_Item_List> mDdlcList;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mListener;
    private Context dcontext;
    private Adapter dAdapter2;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class ddlcViewHolder extends RecyclerView.ViewHolder {
        CardView ddlcCardView;
        ImageView ddlcImageView;
        TextView ddlcTextView;

        ddlcViewHolder(View itemView) {
            super(itemView);
            ddlcCardView = itemView.findViewById(R.id.deltaruneCardView);
            ddlcImageView = itemView.findViewById(R.id.deltaruneImageView);
            ddlcTextView = itemView.findViewById(R.id.deltaruneTextView);

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

    Ddlc_Adapter(ArrayList<Ddlc_Item_List> exampleList) {
        mDdlcList = exampleList;
    }

    @NonNull
    @Override
    public ddlcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune, parent, false);
        return new ddlcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ddlcViewHolder ddlcViewHolder, int position) {
        final Ddlc_Item_List currentItem = mDdlcList.get(position);

        ddlcViewHolder.ddlcTextView.setText(currentItem.getDdlcText());

        Picasso.get()
                .load(currentItem.getDdlcImageRessource())
                .into(ddlcViewHolder.ddlcImageView);

        dcontext = view.getContext();

        SharedPreferences settings = dcontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getDdlcText()) {
                case "C'est parce que j'veux ken !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.Red1)));
                    break;
                case "HAHA !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.orange1)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.green3)));
                    break;
                case "Étagère_sound.ogg":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.green4)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.blue1)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.blue2)));
                    break;
                case "SUPER !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.blue3)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.blue4)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.blue5)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.darkBlue)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.purple)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.purple2)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.pink1)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.pink2)));
                    break;
                case "Iconoclaste_sound.ogg":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.red2)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.red3)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.orange2)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.yellow1)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.green3)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getDdlcText()) {
                case "C'est parce que j'veux ken !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "HAHA !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Étagère_sound.ogg":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue3)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue4)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dGreen)));
                    break;
                case "SUPER !!! (Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dGreen2)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dGreen3)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dGreen4)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dYellow)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dOrange)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dRed)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dRed2)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dPurple3)));
                    break;
                case "Iconoclaste_sound.ogg":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dPurple)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dPurple2)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    ddlcViewHolder.ddlcCardView.setCardBackgroundColor(ColorStateList.valueOf(ddlcViewHolder.ddlcCardView.getResources().getColor(R.color.dBlue3)));
                    break;
            }
        }

        Animation animation = AnimationUtils.loadAnimation(dcontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        ddlcViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return mDdlcList.size();
    }
}
