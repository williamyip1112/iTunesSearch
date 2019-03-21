package com.hfad.itunessearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


interface MusicService
{
    @GET("search?")
    Call<MusicResponse> searchByArtists(@Query("term") String artistName, @Query("limit") int limitResult );


}
