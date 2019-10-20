package com.papple.iconoblast;

import android.content.Context;

public class Zelda_Item_List {
    private int zeldaImageRessource;
    private String zeldaText;
    private Context zcontext;

    Zelda_Item_List(int imageRessource, String text) {
        zeldaImageRessource = imageRessource;
        zeldaText = text;
    }

    int getZeldaImageRessource() {
        return zeldaImageRessource;
    }

    String getZeldaText() {
        return zeldaText;
    }
}
