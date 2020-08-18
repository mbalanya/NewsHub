package com.chalookoba.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mTrendingNewsButton;
    private EditText mHeadlineEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeadlineEditText = (EditText)findViewById(R.id.headlineEditText);
        mTrendingNewsButton = (Button)findViewById(R.id.trendingNewsButton);
        mTrendingNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String headline = mHeadlineEditText.getText().toString();
                Toast.makeText(MainActivity.this, "Hot News", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, TrendingNewsActivity.class);
                intent.putExtra("headline", headline);
                startActivity(intent);
            }
        });
    }
}