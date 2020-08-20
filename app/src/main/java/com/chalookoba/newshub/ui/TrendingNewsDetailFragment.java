package com.chalookoba.newshub.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalookoba.newshub.R;

import butterknife.BindView;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrendingNewsDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrendingNewsDetailFragment newInstance(String param1, String param2) {
        TrendingNewsDetailFragment fragment = new TrendingNewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending_news_detail, container, false);
    }
}