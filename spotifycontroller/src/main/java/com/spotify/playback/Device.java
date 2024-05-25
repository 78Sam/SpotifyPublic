package com.spotify.playback;

public class Device {
    private String id;
    private boolean is_active;
    private boolean is_private_session;
    private boolean is_restricted;
    private String name;
    private boolean supports_volume;
    private String type;
    private int volume_percent;

    public Device(String id, boolean is_active, boolean is_private_session, boolean is_restricted, String name, boolean supports_volume, String type, int volume_percent) {
        this.id = id;
        this.is_active = is_active;
        this.is_private_session = is_private_session;
        this.is_restricted = is_restricted;
        this.name = name;
        this.supports_volume = supports_volume;
        this.type = type;
        this.volume_percent = volume_percent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsActive() {
        return is_active;
    }

    public void setIsActive(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean getIsPrivateSession() {
        return is_private_session;
    }

    public void setIsPrivateSession(boolean is_private_session) {
        this.is_private_session = is_private_session;
    }

    public boolean getIsRestricted() {
        return is_restricted;
    }

    public void setIsRestricted(boolean is_restricted) {
        this.is_restricted = is_restricted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSupportsVolume() {
        return supports_volume;
    }

    public void setSupportsVolume(boolean supports_volume) {
        this.supports_volume = supports_volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolumePercent() {
        return volume_percent;
    }

    public void setVolumePercent(int volume_percent) {
        this.volume_percent = volume_percent;
    }
}
