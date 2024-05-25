package com.spotify.playback;

import java.util.List;

public class Item {

    private String album_type;
    private String album_group;
    private String album_id;
    private List<String> available_markets;
    private List<String> genres;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private String restrictions_reason;
    private String type;
    private String uri;
    private List<Artist> artists;
    private int disc_number;
    private int duration_ms;
    private Boolean explicit;
    private ExternalIds external_ids;
    private String external_url_spotify;
    private String preview_url;
    private int track_number;
    private Boolean is_local;

    public Item(String album_type, String album_group, String album_id, List<String> available_markets, List<String> genres, String href, String id, List<Image> images, String name, String release_date, String release_date_precision, String restrictions_reason, String type, String uri, List<Artist> artists, int disc_number, int duration_ms, boolean explicit, ExternalIds external_ids, String external_url_spotify, String preview_url, int track_number, boolean is_local) {
        this.album_type = album_type;
        this.album_group = album_group;
        this.album_id = album_id;
        this.available_markets = available_markets;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.release_date = release_date;
        this.release_date_precision = release_date_precision;
        this.restrictions_reason = restrictions_reason;
        this.type = type;
        this.uri = uri;
        this.artists = artists;
        this.disc_number = disc_number;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.external_ids = external_ids;
        this.external_url_spotify = external_url_spotify;
        this.preview_url = preview_url;
        this.track_number = track_number;
        this.is_local = is_local;
    }

    public String getAlbumType() {
        return this.album_type;
    }

    public void setAlbumType(String album_type) {
        this.album_type = album_type;
    }

    public String getAlbumGroup() {
        return this.album_group;
    }

    public void setAlbumGroup(String album_group) {
        this.album_group = album_group;
    }

    public String getAlbumId() {
        return this.album_id;
    }

    public void setAlbumId(String album_id) {
        this.album_id = album_id;
    }

    public List<String> getAvailableMarkets() {
        return this.available_markets;
    }

    public void setAvailableMarkets(List<String> available_markets) {
        this.available_markets = available_markets;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public String getRestrictionsReason() {
        return this.restrictions_reason;
    }

    public void setRestrictionsReason(String restrictions_reason) {
        this.restrictions_reason = restrictions_reason;
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

    public int getDiscNumber() {
        return this.disc_number;
    }

    public void setDiscNumber(int disc_number) {
        this.disc_number = disc_number;
    }

    public int getDurationMs() {
        return this.duration_ms;
    }

    public void setDurationMs(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public ExternalIds getExternalIds() {
        return this.external_ids;
    }

    public void setExternalIds(ExternalIds external_ids) {
        this.external_ids = external_ids;
    }

    public String getExternalUrlSpotify() {
        return this.external_url_spotify;
    }

    public void setExternalUrlSpotify(String external_url_spotify) {
        this.external_url_spotify = external_url_spotify;
    }

    public String getPreviewUrl() {
        return this.preview_url;
    }

    public void setPreviewUrl(String preview_url) {
        this.preview_url = preview_url;
    }

    public int getTrackNumber() {
        return this.track_number;
    }

    public void setTrackNumber(int track_number) {
        this.track_number = track_number;
    }

    public Boolean isLocal() {
        return this.is_local;
    }

    public void setLocal(Boolean is_local) {
        this.is_local = is_local;
    }
    
}
