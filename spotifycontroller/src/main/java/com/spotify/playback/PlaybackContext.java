package com.spotify.playback;


public class PlaybackContext {
    
    private String type;
    private String href;
    private ExternalUrl external_urls;
    private String uri;

    public PlaybackContext(String type, String href, ExternalUrl external_urls, String uri) {
        this.type = type;
        this.href = href;
        this.external_urls = external_urls;
        this.uri = uri;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public ExternalUrl getExternalUrls() {
        return this.external_urls;
    }

    public void setExternalUrls(ExternalUrl external_urls) {
        this.external_urls = external_urls;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
}
