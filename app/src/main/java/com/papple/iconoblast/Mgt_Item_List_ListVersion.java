package com.papple.iconoblast;

import android.content.Context;

public class Mgt_Item_List_ListVersion {
    private String mgtButton;
    private Context mcontext;

    Mgt_Item_List_ListVersion(String text) {
        mgtButton = text;
    }

    public String getText() {
        return mgtButton;
    }
}
