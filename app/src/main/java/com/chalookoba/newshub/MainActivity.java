package com.chalookoba.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName(); //TAG to be used for logging
    @BindView(R.id.trendingNewsButton) Button mTrendingNewsButton;
    @BindView(R.id.headlineEditText) EditText mHeadlineEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTrendingNewsButton.setOnClickListener(this); // set onClickListener
    }

    @Override
    public void onClick(View v) {
        String title = mHeadlineEditText.getText().toString();
        Toast.makeText(MainActivity.this, "Hot News", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, TrendingNewsActivity.class); // pass intent to TrendingNewsActivity
        intent.putExtra("title", title);
        startActivity(intent);
    }
}