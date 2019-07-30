package com.papple.iconoblast;

import android.content.Context;

public class Ddlc_Item_List {
    private int ddlcImageRessource;
    private String ddlcText;
    private Context dcontext;

    Ddlc_Item_List(int imageRessource, String text) {
        ddlcImageRessource = imageRessource;
        ddlcText = text;
    }

    int getDdlcImageRessource() {
        return ddlcImageRessource;
    }

    public String getDdlcText() {
        return ddlcText;
    }
}
