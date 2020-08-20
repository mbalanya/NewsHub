package com.chalookoba.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingNewsActivity extends AppCompatActivity {
    @BindView(R.id.headlineTextView) TextView mHeadlineTextView; // access textview
    @BindView(R.id.listView) ListView mListview; // access listview
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    private String[] title = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};
    private String[] author = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs",
            "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups",
            "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news);
        ButterKnife.bind(this);

        TrendingNewsArrayAdapter adapter = new TrendingNewsArrayAdapter(this, android.R.layout.simple_list_item_1, title, author); //instance of custom ArrayAdapter (TrendingNewsArrayAdapter)
        mListview.setAdapter(adapter);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String headline = ((TextView)view).getText().toString();
                Toast.makeText(TrendingNewsActivity.this, headline, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent(); //get intent from MainActivity
        String title = intent.getStringExtra("title");
        mHeadlineTextView.setText("Here is the trending news about " + title);

        NewsApi client = NewsClient.getClient();
        Call<NewsHubSearchResponse> call = client.getHeadlines(title, Constants.NEWS_API_KEY );

        call.enqueue(new Callback<NewsHubSearchResponse>() {
            @Override
            public void onResponse(Call<NewsHubSearchResponse> call, Response<NewsHubSearchResponse> response) {
                if (response.isSuccessful()) {
                    List<Article> articlesList = response.body().getArticles();
                    String[] title = new String[articlesList.size()];
                    String[] author = new String[articlesList.size()];

                    for (int i = 0; i < title.length; i++){
                        title[i] = articlesList.get(i).getTitle();
                    }

                    for (int i = 0; i < author.length; i++) {
                        author[i] = articlesList.get(i).getAuthor();
                    }

                    ArrayAdapter adapter
                            = new TrendingNewsArrayAdapter(TrendingNewsActivity.this, android.R.layout.simple_list_item_1, title, author);
                    mListview.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsHubSearchResponse> call, Throwable t) {

            }

        });
    }
}