package com.chalookoba.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TrendingNewsActivity extends AppCompatActivity {
    private TextView mHeadlineTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news);

        mHeadlineTextView = (TextView) findViewById(R.id.headlineTextView);
        Intent intent = getIntent();
        String headline = intent.getStringExtra("headline");
        mHeadlineTextView.setText("Here is the trending news about " + headline);
    }
}