package com.spotify.playback;

public class ExternalIds {

    private String isrc;
    private String ean;
    private String upc;

    public ExternalIds(String isrc, String ean, String upc) {
        this.isrc = isrc;
        this.ean = ean;
        this.upc = upc;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
    
}
