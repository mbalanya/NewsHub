package com.chalookoba.newshub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chalookoba.newshub.R;
import com.chalookoba.newshub.adapters.TrendingNewsListAdapter;
import com.chalookoba.newshub.models.Article;
import com.chalookoba.newshub.models.NewsHubSearchResponse;
import com.chalookoba.newshub.network.NewsApi;
import com.chalookoba.newshub.network.NewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingNewsListActivity extends AppCompatActivity {
    private static final String TAG = TrendingNewsListActivity.class.getSimpleName();
    /*@BindView(R.id.headlineTextView) TextView mHeadlineTextView; // access textview
    @BindView(R.id.listView) ListView mListview;*/ // access listview
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private TrendingNewsListAdapter mAdapter;
    public List<Article> articles;
    /*private String[] title = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};
    private String[] author = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs",
            "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups",
            "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news);
        ButterKnife.bind(this);

        /*TrendingNewsArrayAdapter adapter = new TrendingNewsArrayAdapter(this, android.R.layout.simple_list_item_1, title, author); //instance of custom ArrayAdapter (TrendingNewsArrayAdapter)
        mListview.setAdapter(adapter);*/

        /*mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() { //adds a toast when clicking
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String headline = ((TextView)view).getText().toString();
                Toast.makeText(TrendingNewsActivity.this, headline, Toast.LENGTH_LONG).show();
            }
        });*/

        Intent intent = getIntent(); //get intent from MainActivity
        String title = intent.getStringExtra("title");

        getArticles(title);

    }

    private void getArticles(String title) {
        NewsApi client = NewsClient.getClient();
        Call<NewsHubSearchResponse> call = client.getHeadlines(title);

        call.enqueue(new Callback<NewsHubSearchResponse>() {
            @Override
            public void onResponse(Call<NewsHubSearchResponse> call, Response<NewsHubSearchResponse> response) {

                hideProgressBar();
                if (response.isSuccessful()) {
                    articles = response.body().getArticles();
                    mAdapter = new TrendingNewsListAdapter(TrendingNewsListActivity.this, articles);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TrendingNewsListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                   /* List<Article> articlesList = response.body().getArticles();
                    String[] title = new String[articlesList.size()];
                    String[] author = new String[articlesList.size()];*/

                    /*for (int i = 0; i < title.length; i++){
                        title[i] = articlesList.get(i).getTitle();
                    }

                    for (int i = 0; i < author.length; i++) {
                        author[i] = articlesList.get(i).getAuthor();
                    }

                    ArrayAdapter adapter
                            = new TrendingNewsArrayAdapter(TrendingNewsActivity.this, android.R.layout.simple_list_item_1, title, author);
                    mListview.setAdapter(adapter);*/

                    showHeadlines();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<NewsHubSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
       mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showHeadlines() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}