package com.hfad.itunessearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class result extends AppCompatActivity {
    private String artistname;
    private TextView top1Song;
    private TextView top2Song;
    private TextView top3Song;
    private TextView top4Song;
    private TextView top5Song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        artistname = getIntent().getStringExtra("Artist");
        searchMusic(artistname);
        wireWidgets();
    }

    private void wireWidgets()
    {
        top1Song = findViewById(R.id.textView_top1song_main);
        top2Song = findViewById(R.id.textView2_top2song_main);
        top3Song = findViewById(R.id.textView3_top3song_main);
        top4Song = findViewById(R.id.textView4_top4song_main);
        top5Song = findViewById(R.id.textView5_top5song_main);
    }

    private void searchMusic(String artistname)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MusicService service = retrofit.create(MusicService.class);
        Call<MusicResponse> musicResponseCall = service.searchByArtists(artistname, 5);

        musicResponseCall.enqueue(new Callback<MusicResponse>()
        {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response)
            {
                Log.d("ENQUEUE", "onResponse: response" + (response == null));
                Log.d("ENQUEUE", "onResponse: response body" + (response.body() ==null));
                List<Music> music = response.body().getResults();
                Log.d("ENQUEUE", "onResponse:" + music.toString());
                top1Song.setText("#1 Song: " + music.get(0).getTrackName() + " by " + music.get(0).getArtistname());
                top2Song.setText("#2 Song: " + music.get(1).getTrackName() + " by " + music.get(1).getArtistname());
                top3Song.setText("#3 Song: " + music.get(2).getTrackName() + " by " + music.get(2).getArtistname());
                top4Song.setText("#4 Song: " + music.get(3).getTrackName() + " by " + music.get(3).getArtistname());
                top5Song.setText("#5 Song: " + music.get(4).getTrackName() + " by " + music.get(4).getArtistname());

            }
            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t)
            {
                Log.d("ENQUEUE", "onFailure" + t.getMessage());
            }

        });

    }

}
