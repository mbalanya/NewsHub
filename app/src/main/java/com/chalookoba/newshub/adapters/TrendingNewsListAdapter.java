package com.chalookoba.newshub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chalookoba.newshub.Constants;
import com.chalookoba.newshub.R;
import com.chalookoba.newshub.models.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingNewsListAdapter extends RecyclerView.Adapter<TrendingNewsListAdapter.TrendingNewsViewHolder> {
    private List<Article> mArticles;
    private Context mContext;

    public TrendingNewsListAdapter(Context context, List<Article> articles) {
        mContext = context;
        mArticles = articles;
    }



    public class TrendingNewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.trendingNewsImageView) ImageView mTrendingNewsImageView;
        @BindView(R.id.trendingNewsNameTextView) TextView mTrendingNewsNameTextView;
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.postedAtTextView) TextView mPostedAtTextView;

        private Context mContext;


    }
}
