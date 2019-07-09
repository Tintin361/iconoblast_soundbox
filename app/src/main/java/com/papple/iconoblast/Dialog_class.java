package com.papple.iconoblast;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Dialog_class extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (super.getActivity() != null) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#00ff21'>WHAT'S UP ? - Debug(0.17)</font>"))
                    .setMessage("- Changement dans les string.\n" +
                                "- Change de la bannière du Drawer.\n" +
                                "- Changement de la police d'écriture.\n" +
                                "- Ajout de la page Deltarune ainsi que de nouveaux sons.\n" +
                                "- Correction du toast quand l'utilisateur change de thème." +
                                "- Modification de la bottom nav bar dans Informations.\n")
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
