package com.chalookoba.newshub.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TrendingNewsArrayAdapter extends ArrayAdapter { // this adapter passes data from TrendingNewsActivity to be displayed on the layout
    private Context mContext;
    private String[] mTitle;
    private String[] mAuthor;

    public TrendingNewsArrayAdapter(Context mContext, int resource, String[] mTitle, String[] mAuthor) { // the constructor
        super(mContext, resource);
        this.mContext = mContext;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
    }

    @Override
    public Object getItem(int position) { // required by ArrayAdapter
        String title = mTitle[position];
        String author = mAuthor[position];
        return String.format("%s \nWritten by: %s", title, author);
    }

    @Override
    public int getCount() { // required by ArrayAdapter
        return mTitle.length;
    }
}
