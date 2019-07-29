package com.papple.iconoblast;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;

public class Dialog_class extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (super.getActivity() != null) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.20.2)</font>"))
                    .setMessage("- Le nouveau design se déploie petit à petit.\n" +
                                "- Nouveau menu de recherche !\n"+
                                "- Nouvelles animations !\n" +
                                "- Correction d'un bug sur l'affichage en liste dans la catégorie Deltarune.\n" +
                            "- Correction de bugs sur le système de MàJ.\n" +
                                "- Changement dans les Strings.\n" +
                                "- Système de Màj via GitHub.\n" +
                                "- Certaines animations sont plus rapide.\n" +
                                "- Modifications mineures.\n")
                    .setPositiveButton(Html.fromHtml("<font color='#dd117e'>OK</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create();
        } else {
            throw new RuntimeException("null returned from getActivity()");
        }
    }

}
