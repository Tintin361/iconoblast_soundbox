package com.papple.iconoblast;

import android.content.Context;

public class Deltarune_Item_List {
    private int mImageRessource;
    private String mText;
    private Context context;

    Deltarune_Item_List(int imageRessource, String text) {
        mImageRessource = imageRessource;
        mText = text;
    }

    int getImageRessource() {
        return mImageRessource;
    }

    public String getText(){
        return mText;
    }
}
