package com.chalookoba.newshub;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TrendingNewsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTitle;
    private String[] mAuthor;

    public TrendingNewsArrayAdapter(Context mContext, int resource, String[] mTitle, String[] mAuthor) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
    }

    @Override
    public Object getItem(int position) {
        String title = mTitle[position];
        String author = mAuthor[position];
        return String.format("%s \nWritten by: %s", title, author);
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }
}
