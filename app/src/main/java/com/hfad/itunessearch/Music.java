package com.hfad.itunessearch;

class Music
{
    private String artistName;
    private String trackName;


    public String getArtistname() {
        return artistName;
    }

    public void setArtistname(String artistName) {
        this.artistName = artistName;
    }
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Music()
    {

    }
    @Override
    public String toString()
    {
        return trackName  + " by " + artistName;
    }



}
