package com.papple.iconoblast;

import android.content.Context;

class Mgt_Item_List {
    private int mgtImageRessource;
    private String mgtText;
    private Context mcontext;

    Mgt_Item_List(int imageRessource, String text) {
        mgtImageRessource = imageRessource;
        mgtText = text;
    }

    int getMgtImageRessource() {
        return mgtImageRessource;
    }

    String getMgtText() {
        return mgtText;
    }
}
