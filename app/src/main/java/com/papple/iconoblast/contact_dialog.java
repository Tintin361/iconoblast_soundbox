package com.papple.iconoblast;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.text.Html;

public class contact_dialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (super.getActivity() != null) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(Html.fromHtml("<font color='#ff0000'>REPORTER UN BUG</font>"))
                    .setMessage("Si jamais vous subissez un bug, n'hésitez pas à envoyer un commentaire sur la page Google Play de l'application.")
                    .setPositiveButton(Html.fromHtml("<font color='#E75A4D'>Ok</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            String url = "https://play.google.com/store/apps/details?id=com.papple.iconoblast&gl=FR";
                            intent.setData(Uri.parse(url));
                            startActivity(intent);
                        }
                    })
                    .setNeutralButton(Html.fromHtml("<font color='#9800ff'>Annuler</font>"), new DialogInterface.OnClickListener() {
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
