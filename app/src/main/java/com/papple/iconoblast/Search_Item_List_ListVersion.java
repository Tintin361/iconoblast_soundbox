package com.papple.iconoblast;

import android.content.Context;

import java.util.logging.Filter;

public class Search_Item_List_ListVersion {
    private String sButton;
    private Context sContext;
    private Filter sFilter;

    Search_Item_List_ListVersion(String text) {
        sButton = text;
    }

    public String getText(){
        return sButton;
    }

    public Filter getFilter(){
        return sFilter;
    }
}
