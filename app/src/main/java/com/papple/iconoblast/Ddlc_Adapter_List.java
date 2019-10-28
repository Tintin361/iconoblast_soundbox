package com.papple.iconoblast;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;

import java.util.ArrayList;

public class Ddlc_Adapter_List extends RecyclerView.Adapter<Ddlc_Adapter_List.ddlcViewHolder> {
    private ArrayList<Ddlc_Item_List_ListVersion> ddlcList;
    private RecyclerView ddlcRecyclerView;
    private OnItemClickListener ddlcListener;
    private Context ddlccontext;
    private Adapter ddlcAdapter;
    private int lastPosition = -1;
    View view;

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        ddlcListener = listener;
    }

    class ddlcViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        ddlcViewHolder(View itemView) {
            super(itemView);
            mButton = view.findViewById(R.id.deltaruneButton);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ddlcListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            ddlcListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    Ddlc_Adapter_List(ArrayList<Ddlc_Item_List_ListVersion> exampleList) {
        ddlcList = exampleList;
    }

    @NonNull
    @Override
    public ddlcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_deltarune_listversion, parent, false);
        return new ddlcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ddlcViewHolder ddlcViewHolder, int position) {
        Ddlc_Item_List_ListVersion currentItem = ddlcList.get(position);

        ddlcViewHolder.mButton.setText(currentItem.getText());

        ddlccontext = view.getContext();

        SharedPreferences settings = ddlccontext.getSharedPreferences("Answers", 0);
        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);

        if (answerA) {
            switch (currentItem.getText()) {
                case "C'est parce que j'veux ken !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.Red1)));
                    break;
                case "HAHA !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.orange1)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.yellow1)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.green3)));
                    break;
                case "Étagère_sound.ogg":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.green4)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue1)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue2)));
                    break;
                case "SUPER !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue3)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue4)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue5)));
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.darkBlue)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.purple)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.purple2)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.pink1)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.pink2)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.red2)));
                    break;
                case "Iconoclaste_sound.ogg":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.red3)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.orange2)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.yellow1)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.green3)));
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.green4)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue1)));
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue2)));
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.blue3)));
                    break;
            }

        } else if (answerB) {
            switch (currentItem.getText()) {
                case "C'est parce que j'veux ken !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dPurple)));
                    break;
                case "HAHA !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Donc tu devais peut-être… (Étagèrito)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue)));
                    break;
                case "Hey ! Fait attention… (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Étagère_sound.ogg":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue3)));
                    break;
                case "MMMMMMH !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue4)));
                    break;
                case "GÉNIAL !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen)));
                    break;
                case "SUPER !!! (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen2)));
                    break;
                case "Tu ne devrai pas avoir peur d'expérimenter ! (Étagère.exe)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen3)));
                    break;
                case "Rire (pas) diabolique (Grand Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen4)));
                    break;
                case "Tu as un cul énorme. (Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dYellow)));
                    break;
                case "MAIS BORDEL, ÇA VA PAS LA TÊTE ?! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dOrange)));
                    break;
                case "BAAAAKA !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dRed)));
                    break;
                case "Cailoux, CAILOOOOOUUUXXX !!! (encore Ico…)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dRed2)));
                    break;
                case "Actuellement, je pense encore à… (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dPurple3)));
                    break;
                case "CRACHE LE MORCEAU, ENCULÉ !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dPurple)));
                    break;
                case "Iconoclaste_sound.ogg":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dPurple2)));
                    break;
                case "Non ! NOOOOOON !!! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue)));
                    break;
                case "(Censuré) oh pardon, c'est sorti tout seul ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue2)));
                    break;
                case "Pour baiser ! POUR BAISER ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue3)));
                    break;
                case "EEEAAAAAARG ! (Ico)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dBlue4)));
                    break;
                case "Tu dis que de la merde ! SUPER ! (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen)));
                    break;
                case "L'Étagère sonne creux... (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen2)));
                    break;
                case "Etemaaaaaaaaath !! (Ico et Étagère)":
                    ddlcViewHolder.mButton.setSupportBackgroundTintList(ColorStateList.valueOf(ddlcViewHolder.mButton.getResources().getColor(R.color.dGreen3)));
                    break;
            }
        }


        Animation animation = AnimationUtils.loadAnimation(ddlccontext,
                (position > lastPosition) ? R.anim.up_from_bottom2
                        : R.anim.down_from_top2);
        ddlcViewHolder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return ddlcList.size();
    }

}

