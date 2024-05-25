package com.spotify.data.playlists.playlist;

import java.util.List;

import com.spotify.playback.ExternalUrl;
import com.spotify.playback.Image;

public class Album {
    
    private String album_type;
    private int total_tracks;
    private List<String> available_markets;
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private Restrictions restrictions;
    private String type;
    private String uri;
    private List<Artist> artists;

    public Album(String album_type, int total_tracks, List<String> available_markets, ExternalUrl external_urls, String href, String id, List<Image> images, String name, String release_date, String release_date_precision, Restrictions restrictions, String type, String uri, List<Artist> artists) {
        this.album_type = album_type;
        this.total_tracks = total_tracks;
        this.available_markets = available_markets;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.release_date = release_date;
        this.release_date_precision = release_date_precision;
        this.restrictions = restrictions;
        this.type = type;
        this.uri = uri;
        this.artists = artists;
    }

    public String getAlbumType() {
        return this.album_type;
    }

    public void setAlbumType(String album_type) {
        this.album_type = album_type;
    }

    public int getTotalTracks() {
        return this.total_tracks;
    }

    public void setTotalTracks(int total_tracks) {
        this.total_tracks = total_tracks;
    }

    public List<String> getAvailableMarkets() {
        return this.available_markets;
    }

    public void setAvailableMarkets(List<String> available_markets) {
        this.available_markets = available_markets;
    }

    public ExternalUrl getExternalUrls() {
        return this.external_urls;
    }

    public void setExternalUrls(ExternalUrl external_urls) {
        this.external_urls = external_urls;
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

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return this.release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public String getReleaseDatePrecision() {
        return this.release_date_precision;
    }

    public void setReleaseDatePrecision(String release_date_precision) {
        this.release_date_precision = release_date_precision;
    }

    public Restrictions getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
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

    public List<Artist> getArtists() {
        return this.artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}
