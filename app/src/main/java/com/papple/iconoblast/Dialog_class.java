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
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.21.4)</font>"))
                    .setMessage("- Modifications mineures.\n" +
                            "- Mise à Jour des bibliothèques Android.\n" +
                            "- Deux nouveaux sons arriveront avec la version 0.22.\n" +
                            "- Ajout d'un Easter egg en rapport avec l'ermite moderne.\n" +
                            "- L'application peut etre deplacée sur la carte SD.\n" +
                            "- Correction de bugs.")
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
