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
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.15)</font>"))
                    .setMessage("- Changement dans les string.\n" +
                                "- Ajout d'un fragment Statistiques.\n" +
                                "- Ajout d'une récompense quotidienne.\n")
                    .setPositiveButton(Html.fromHtml("<font color='#dd117e'>OK</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create();

    }
}
