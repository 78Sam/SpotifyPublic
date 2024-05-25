package com.spotify.playback;

import java.math.BigInteger;

public class CurrentPlayback {

    private Device device;
    private String repeat_state;
    private boolean shuffle_state;
    private PlaybackContext context;
    private BigInteger timestamp;
    private int progress_ms;
    private boolean is_playing;
    private Item item;
    private String currently_playing_type;
    private Actions actions;

    public CurrentPlayback(Device device, String repeat_state, boolean shuffle_state, PlaybackContext context, BigInteger timestamp, int progress_ms, boolean is_playing, Item item, String currently_playing_type, Actions actions) {
        this.device = device;
        this.repeat_state = repeat_state;
        this.shuffle_state = shuffle_state;
        this.context = context;
        this.timestamp = timestamp;
        this.progress_ms = progress_ms;
        this.is_playing = is_playing;
        this.item = item;
        this.currently_playing_type = currently_playing_type;
        this.actions = actions;
    }
    
    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getRepeatState() {
        return this.repeat_state;
    }

    public void setRepeatState(String repeat_state) {
        this.repeat_state = repeat_state;
    }

    public boolean getShuffleState() {
        return this.shuffle_state;
    }

    public void setShuffleState(boolean shuffle_state) {
        this.shuffle_state = shuffle_state;
    }

    public PlaybackContext getPlaybackContext() {
        return this.context;
    }

    public void getPlaybackContext(PlaybackContext context) {
        this.context = context;
    }

    public BigInteger getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public int getProgressMs() {
        return this.progress_ms;
    }

    public void setProgressMs(int progress_ms) {
        this.progress_ms = progress_ms;
    }

    public boolean getIsPlaying() {
        return this.is_playing;
    }

    public void setIsPlaying(boolean is_playing) {
        this.is_playing = is_playing;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getCurrentlyPlayingType() {
        return this.currently_playing_type;
    }

    public void setCurrentlyPlayingType(String currently_playing_type) {
        this.currently_playing_type = currently_playing_type;
    }

    public Actions getActions() {
        return this.actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }


}
