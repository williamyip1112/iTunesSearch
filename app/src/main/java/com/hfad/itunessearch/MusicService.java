package com.hfad.itunessearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


interface MusicService
{
    @GET("api/")
    Call<MusicResponse> searchByArtists(@Query("i") String artisttName);


}
