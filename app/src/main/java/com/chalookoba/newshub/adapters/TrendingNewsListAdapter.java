package com.chalookoba.newshub.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chalookoba.newshub.Constants;
import com.chalookoba.newshub.R;
import com.chalookoba.newshub.models.Article;
import com.chalookoba.newshub.ui.TrendingNewsDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

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

    public class TrendingNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.trendingNewsImageView) ImageView mTrendingNewsImageView;
        @BindView(R.id.trendingNewsNameTextView) TextView mTrendingNewsNameTextView;
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.postedAtTextView) TextView mPostedAtTextView;

        private Context mContext;

        public TrendingNewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TrendingNewsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("articles", Parcels.wrap(mArticles));
            mContext.startActivity(intent);
        }

        public void bindTrendingNews(Article article) {
            Picasso.get().load(article.getUrlToImage()).into(mTrendingNewsImageView);
            mTrendingNewsNameTextView.setText(article.getTitle());
            mAuthorTextView.setText(article.getAuthor());
            mPostedAtTextView.setText("Posted at: " + article.getPublishedAt());
        }
    }

    @NonNull
    @Override
    public TrendingNewsListAdapter.TrendingNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_news_list_item, parent, false);
        TrendingNewsViewHolder viewHolder = new TrendingNewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingNewsListAdapter.TrendingNewsViewHolder holder, int position) {
        holder.bindTrendingNews(mArticles.get(position));
    }

    @Override
    public int getItemCount(){
        return mArticles.size();
    }
}
