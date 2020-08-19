package com.chalookoba.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TrendingNewsActivity extends AppCompatActivity {
    private TextView mHeadlineTextView;
    private ListView mListview;
    private String[] headlines = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news);

        mListview = (ListView) findViewById(R.id.listView);
        mHeadlineTextView = (TextView) findViewById(R.id.headlineTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, headlines);
        mListview.setAdapter(adapter);

        Intent intent = getIntent();
        String headline = intent.getStringExtra("headline");
        mHeadlineTextView.setText("Here is the trending news about " + headline);
    }
}