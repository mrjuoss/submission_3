package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.viewmodel;

import android.content.Context;

public class ResourceLang {
    private Context mContext;

    public ResourceLang(Context mContext) {
        this.mContext = mContext;
    }

    public String getString(int langId) {
        return mContext.getString(langId);
    }

    public String getString(int langId, String value) {
        return mContext.getString(langId, value);
    }
}
