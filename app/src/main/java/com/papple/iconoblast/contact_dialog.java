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
                    .setMessage("Si jamais vous subissez un bug, n'hésitez pas à envoyer un message privé sur Twitter ou un mail.")
                    .setPositiveButton(Html.fromHtml("<font color='#E75A4D'>Mail</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("mailto:tintin361official@gmail.com"));
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Bug(s) sur l'application Iconoblast !");
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton(Html.fromHtml("<font color='#1DA1F2'>Twitter</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String url = "https://twitter.com/papple_studio";
                            Intent web = new Intent(Intent.ACTION_VIEW);
                            web.setData(Uri.parse(url));
                            startActivity(web);
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
