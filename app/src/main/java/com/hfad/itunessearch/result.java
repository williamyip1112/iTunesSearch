package com.hfad.itunessearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class result extends AppCompatActivity {
    private String artistname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        artistname = getIntent().getStringExtra("Artist");
        searchMusic(artistname);
    }
    private void searchMusic(String artistname)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MusicService service = retrofit.create(MusicService.class);
        Call<MusicResponse> musicResponseCall = service.searchByArtists(artistname);

        musicResponseCall.enqueue(new Callback<MusicResponse>()
        {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response)
            {
                Log.d("ENQUEUE", "onResponse: response" + (response == null));
                Log.d("ENQUEUE", "onResponse: response body" + (response.body() ==null));
                List<Music> music = response.body().getResults();
                Log.d("ENQUEUE", "onResponse:" + music.toString());
            }
            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t)
            {
                Log.d("ENQUEUE", "onFailure" + t.getMessage());
            }

        });

    }
}
