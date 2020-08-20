package com.chalookoba.newshub.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chalookoba.newshub.models.Article;
import com.chalookoba.newshub.ui.TrendingNewsDetailFragment;

import java.util.List;

public class TrendingNewsPagerAdapter extends FragmentPagerAdapter {
    private List<Article> mArticles;

    public TrendingNewsPagerAdapter(FragmentManager fm, int behavior, List<Article> articles) {
        super(fm, behavior);
        mArticles = articles;
    }

    @Override
    public Fragment getItem(int position) {
        return TrendingNewsDetailFragment.newInstance(mArticles.get(position));
    }

    @Override
    public int getCount() {
        return mArticles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArticles.get(position).getTitle();
    }
}
