package com.spotify.data.playlists;

public class Tracks {
    
    private String href;
    private int total;

    public Tracks(String href, int total) {
        this.href = href;
        this.total = total;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
