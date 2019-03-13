package com.hfad.itunessearch;

import java.util.List;

class MusicResponse
{
    private int resultCount;
    private List<Music> results;

    public MusicResponse()
    {

    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Music> getResults() {
        return results;
    }

    public void setResults(List<Music> results) {
        this.results = results;
    }
}
