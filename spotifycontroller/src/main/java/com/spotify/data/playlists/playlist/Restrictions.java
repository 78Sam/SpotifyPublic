package com.spotify.data.playlists.playlist;

public class Restrictions {
    
    private String reason;

    public Restrictions(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
