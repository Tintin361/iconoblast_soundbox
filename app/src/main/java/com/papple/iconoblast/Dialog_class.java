package com.papple.iconoblast;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
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
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.14)</font>"))
                    .setMessage("- Réduction du temps de chargement de l'application.\n" +
                            "- Réduction de la taille de l'application.\n" +
                            "- Application peut maintenant lire les fichier .opus pour une meilleure qualité audio.\n" +
                            "- Ajout de raccourcis lors d'un clic long sur l'icon de l'application.\n" +
                            "- Changement dans les string.\n" +
                            "- MàJ des outils de développement Android.\n")
                    .setPositiveButton(Html.fromHtml("<font color='#dd117e'>OK</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create();
        } else {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.14)</font>"))
                    .setMessage("- Réduction du temps de chargement de l'application.\n" +
                            "- Réduction de la taille de l'application.\n" +
                            "- Application peut maintenant lire les fichier .opus pour une meilleure qualité audio.\n" +
                            "- Changement dans les string.\n" +
                            "- MàJ des outils de développement Android.\n")
                    .setPositiveButton(Html.fromHtml("<font color='#dd117e'>OK</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create();
        }
    }
}
