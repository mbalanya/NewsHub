package com.chalookoba.newshub.network;

import com.chalookoba.newshub.models.NewsHubSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsHubSearchResponse> getHeadlines(
            @Query("sources") String title
    );
}
