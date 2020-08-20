package com.chalookoba.newshub;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsHubSearchResponse> getHeadlines(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey
    );
}
