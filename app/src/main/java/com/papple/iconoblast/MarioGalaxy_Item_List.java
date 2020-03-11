package com.papple.iconoblast;

import android.content.Context;

public class MarioGalaxy_Item_List {
    private int marioGalaxyImageRessource;
    private String marioGalaxyText;
    private Context gcontext;

    MarioGalaxy_Item_List(int imageRessource, String text) {
        marioGalaxyImageRessource = imageRessource;
        marioGalaxyText = text;
    }

    int getMarioGalaxyImageRessource() {
        return marioGalaxyImageRessource;
    }

    public String getMarioGalaxyText() {
        return marioGalaxyText;
    }
}
