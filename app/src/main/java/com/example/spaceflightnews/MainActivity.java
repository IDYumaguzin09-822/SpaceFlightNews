package com.example.spaceflightnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spaceflightnews.model.SpaceFlightNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final String BASE_URL = "https://test.spaceflightnewsapi.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space_flight_news_activity);

        RecyclerView recyclerView = findViewById(R.id.space_flight_recycle_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpaceFlightAPI spaceFlightAPI = retrofit.create(SpaceFlightAPI.class);

        Call<List<SpaceFlightNews>> listCall = spaceFlightAPI.getSpaceFlightNews();

        listCall.enqueue(new Callback<List<SpaceFlightNews>>() {
            @Override
            public void onResponse(Call<List<SpaceFlightNews>> call, Response<List<SpaceFlightNews>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }

                List<SpaceFlightNews> spaceFlightNewsList = response.body();
                DataAdapter adapter = new DataAdapter(MainActivity.this, spaceFlightNewsList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<SpaceFlightNews>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}