package com.papple.iconoblast;

import android.content.Context;

import java.util.logging.Filter;

public class Search_Item_List {
    private int sImageRessource;
    private String sButton;
    private Context sContext;
    private Filter sFilter;

    Search_Item_List(int imageRessource, String text) {
        sImageRessource = imageRessource;
        sButton = text;
    }

    String getSearchText() {
        return sButton;
    }

    public Filter getFilter() {
        return sFilter;
    }

    public Context getContext() {
        return sContext;
    }

    int getImageRessource() {
        return sImageRessource;
    }
}
