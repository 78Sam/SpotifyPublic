package com.spotify.data.playlists;

import com.spotify.playback.ExternalUrl;

public class Owner {

    private ExternalUrl external_urls;
    private Followers followers;
    private String href;
    private String id;
    private String type;
    private String uri;
    private String display_name;

    public Owner(ExternalUrl external_urls, Followers followers, String href, String id, String type, String uri, String display_name) {
        this.external_urls = external_urls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
        this.display_name = display_name;
    }

    public ExternalUrl getExternalUrls() {
        return this.external_urls;
    }

    public void setExternalUrls(ExternalUrl external_urls) {
        this.external_urls = external_urls;
    }

    public Followers getFollowers() {
        return this.followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDisplayName() {
        return this.display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }

}