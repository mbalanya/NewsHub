package com.chalookoba.newshub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcel;

import com.chalookoba.newshub.R;
import com.chalookoba.newshub.adapters.TrendingNewsPagerAdapter;
import com.chalookoba.newshub.models.Article;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingNewsDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private TrendingNewsPagerAdapter adapterViewPager;
    List<Article> mArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news_detail);
        ButterKnife.bind(this);

        mArticles = Parcels.unwrap(getIntent().getParcelableExtra("articles"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new TrendingNewsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mArticles);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}