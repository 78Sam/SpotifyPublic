package com.spotify.data.playlists.playlist;

import java.util.List;

import com.spotify.playback.ExternalIds;
import com.spotify.playback.ExternalUrl;

public class Track {
    
    private Album album;
    private List<DetailedArtist> artists;
    private List<String> available_markets;
    private int disc_number;
    private int duration_ms;
    private boolean explicit;
    private ExternalIds external_ids;
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private boolean is_playable;
    private LinkedFrom linked_from;
    private Restrictions restrictions;
    private String name;
    private int popularity;
    private String preview_url;
    private int track_number;
    private String type;
    private String uri;
    private boolean is_local;

    public Track(Album album, List<DetailedArtist> artists, List<String> available_markets, int disc_number, int duration_ms, boolean explicit, ExternalIds external_ids, ExternalUrl external_urls, String href, String id, boolean is_playable, LinkedFrom linked_from, Restrictions restrictions, String name, int popularity, String preview_url, int track_number, String type, String uri, boolean is_local) {
        this.album = album;
        this.artists = artists;
        this.available_markets = available_markets;
        this.disc_number = disc_number;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.external_ids = external_ids;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.is_playable = is_playable;
        this.linked_from = linked_from;
        this.restrictions = restrictions;
        this.name = name;
        this.popularity = popularity;
        this.preview_url = preview_url;
        this.track_number = track_number;
        this.type = type;
        this.uri = uri;
        this.is_local = is_local;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<DetailedArtist> getArtists() {
        return this.artists;
    }

    public void setArtists(List<DetailedArtist> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return this.available_markets;
    }

    public void setAvailableMarkets(List<String> available_markets) {
        this.available_markets = available_markets;
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

    public boolean getExplicit() {
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

    public boolean isIsPlayable() {
        return this.is_playable;
    }

    public boolean getIsPlayable() {
        return this.is_playable;
    }

    public void setIs_playable(boolean is_playable) {
        this.is_playable = is_playable;
    }

    public LinkedFrom getLinkedFrom() {
        return this.linked_from;
    }

    public void setLinkedFrom(LinkedFrom linked_from) {
        this.linked_from = linked_from;
    }

    public Restrictions getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
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

    public boolean isIsLocal() {
        return this.is_local;
    }

    public boolean getIsLocal() {
        return this.is_local;
    }

    public void setIsLocal(boolean is_local) {
        this.is_local = is_local;
    }

}
