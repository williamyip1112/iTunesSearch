package com.hfad.itunessearch;

import android.content.Intent;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText artist;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
    }

    private void setListeners()
    {
        search.setOnClickListener(this);
    }

    private void wireWidgets()
    {
        artist = findViewById(R.id.editText_searchArtist_main);
        search = findViewById(R.id.button_searchButton_main);
    }

    @Override
    public void onClick(View v)
    {
        String artistname = artist.getText().toString();
        switch(v.getId())
        {
            case R.id.button_searchButton_main:

                Intent intentResults = new Intent(MainActivity.this, result.class);
                intentResults.putExtra("Artist", artistname);
                startActivity(intentResults);

        }
    }
}
