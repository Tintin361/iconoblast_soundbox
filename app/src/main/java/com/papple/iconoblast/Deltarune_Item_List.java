package com.papple.iconoblast;

public class Deltarune_Item_List {
    private int mImageRessource;
    private String mText;

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
