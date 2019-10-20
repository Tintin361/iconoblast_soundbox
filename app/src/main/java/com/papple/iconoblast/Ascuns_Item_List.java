package com.papple.iconoblast;

import android.content.Context;

public class Ascuns_Item_List {
    private int ascunsImageRessource;
    private String ascunsText;
    private Context acontext;

    Ascuns_Item_List(int imageRessource, String text) {
        ascunsImageRessource = imageRessource;
        ascunsText = text;
    }

    int getAscunsImageRessource() {
        return ascunsImageRessource;
    }

    public String getAscunsText() {
        return ascunsText;
    }
}
