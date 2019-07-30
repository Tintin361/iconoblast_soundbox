package com.papple.iconoblast;

import android.content.Context;

public class Ddlc_Item_List_ListVersion {
    private String ddlcButton;
    private Context ddlccontext;

    Ddlc_Item_List_ListVersion(String text) {
        ddlcButton = text;
    }

    public String getText() {
        return ddlcButton;
    }
}
