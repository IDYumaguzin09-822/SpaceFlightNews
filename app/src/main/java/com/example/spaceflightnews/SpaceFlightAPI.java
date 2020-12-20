package com.example.spaceflightnews;

import com.example.spaceflightnews.model.SpaceFlightNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceFlightAPI {
    @GET("api/v2/articles")
    Call<List<SpaceFlightNews>> getSpaceFlightNews();
}
