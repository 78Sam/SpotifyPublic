package com.spotify.data.playlists;

import java.util.List;

import com.spotify.playback.ExternalUrl;
import com.spotify.playback.Image;

public class Item {

    private Boolean collaborative;
    private String description;
    private ExternalUrl external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Owner owner;
    private Boolean public_;
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;

    public Item(Boolean collaborative, String description, ExternalUrl external_urls, String href, String id, List<Image> images, String name, Owner owner, Boolean public_, String snapshot_id, Tracks tracks, String type, String uri) {
        this.collaborative = collaborative;
        this.description = description;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.owner = owner;
        this.public_ = public_;
        this.snapshot_id = snapshot_id;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    public Boolean isCollaborative() {
        return this.collaborative;
    }

    public Boolean getCollaborative() {
        return this.collaborative;
    }

    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean isPublic_() {
        return this.public_;
    }

    public Boolean getPublic_() {
        return this.public_;
    }

    public void setPublic_(Boolean public_) {
        this.public_ = public_;
    }

    public String getSnapshotId() {
        return this.snapshot_id;
    }

    public void setSnapshotId(String snapshot_id) {
        this.snapshot_id = snapshot_id;
    }

    public Tracks getTracks() {
        return this.tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
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

}
