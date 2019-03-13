package com.hfad.itunessearch;

class Music
{
    private String artistName;

    public String getArtistname() {
        return artistName;
    }

    public void setArtistname(String artistName) {
        this.artistName = artistName;
    }

    public Music()
    {

    }
    @Override
    public String toString()
    {
        return "Music{" + "artistName=" + artistName + '\'';
    }

}
