package com.chalookoba.newshub.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalookoba.newshub.R;
import com.chalookoba.newshub.models.Article;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendingNewsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendingNewsDetailFragment extends Fragment {
    @BindView(R.id.trendingNewsDetailImageView) ImageView mImageLabel;
    @BindView(R.id.trendingNewsDetailNameTextView) TextView mTitleLabel;
    @BindView(R.id.authorTextView) TextView mAuthorLabel;
    @BindView(R.id.publishedTextView) TextView mPublishedLabel;
    @BindView(R.id.contentTextView) TextView mContentLabel;
    @BindView(R.id.linkTextView) TextView mLinkLabel;
    @BindView(R.id.saveTrendingNewsDetailButton) Button mSaveTrendingNewsDetailButton;

    private Article mArticle;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrendingNewsDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TrendingNewsDetailFragment newInstance(Article article) {
        TrendingNewsDetailFragment trendingNewsDetailFragment = new TrendingNewsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("article", Parcels.wrap(article));
        trendingNewsDetailFragment.setArguments(args);
        return trendingNewsDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArticle = Parcels.unwrap(getArguments().getParcelable("article"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trending_news_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mArticle.getUrlToImage()).into(mImageLabel);

        mTitleLabel.setText(mArticle.getTitle());
        mAuthorLabel.setText(mArticle.getAuthor());
        mPublishedLabel.setText(mArticle.getPublishedAt());
        mContentLabel.setText(mArticle.getContent());
        mLinkLabel.setText(mArticle.getUrl());

        return view;
    }
}