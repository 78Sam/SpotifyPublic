package com.spotify.data.playlists.playlist;

public class PlaylistItem {
    
    private String added_at;
    private AddedBy added_by;
    private Boolean is_local;
    private Track track;

    public PlaylistItem(String added_at, AddedBy added_by, Boolean is_local, Track track) {
        this.added_at = added_at;
        this.added_by = added_by;
        this.is_local = is_local;
        this.track = track;
    }

    public String getAddedAt() {
        return this.added_at;
    }

    public void setAddedAt(String added_at) {
        this.added_at = added_at;
    }

    public AddedBy getAddedBy() {
        return this.added_by;
    }

    public void setAddedBy(AddedBy added_by) {
        this.added_by = added_by;
    }

    public Boolean isIsLocal() {
        return this.is_local;
    }

    public Boolean getIsLocal() {
        return this.is_local;
    }

    public void setIsLocal(Boolean is_local) {
        this.is_local = is_local;
    }

    public Track getTrack() {
        return this.track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
