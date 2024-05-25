package com.spotify.data;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import com.spotify.auth.AccessToken;
import com.spotify.data.playlists.Playlists;
import com.spotify.data.playlists.playlist.Playlist;
import com.spotify.playback.CurrentPlayback;
import com.spotify.playback.Devices;

public class SpotifyClient {

    private final String grant_type = "client_credentials";
    private String client_id;
    private String client_secret;

    private AccessToken token;
    private AccessToken auth_token;

    private CurrentPlayback current_playback;

    private Devices devices;
    private Playlists playlists;
    private Playlist current_playlist;

    public SpotifyClient() {

        try {

            Scanner file_reader = new Scanner(new File("creds.txt"));

            if (file_reader.hasNextLine()) {
                this.client_id = file_reader.nextLine();
            }

            if (file_reader.hasNextLine()) {
                this.client_secret = file_reader.nextLine();
            }

            file_reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getGrantType() {
        return this.grant_type;
    }

    public String getClientID() {
        return this.client_id;
    }

    public String getClientSecret() {
        return this.client_secret;
    }

    public void setToken(AccessToken token) {
        this.token = token;
    }

    public void setAuthToken(AccessToken token) {
        this.auth_token = token;
    }

    public AccessToken getAuthToken() {
        return this.auth_token;
    }

    public AccessToken getAccessToken() {
        return this.token;
    }

    public void setCurrentPlayback(CurrentPlayback current_playback) {
        this.current_playback = current_playback;
    }

    public CurrentPlayback getCurrentPlayback() {
        return this.current_playback;
    }

    public Devices getDevices() {
        return this.devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public void setPlaylists(Playlists playlists) {
        this.playlists = playlists;
    }

    public Playlists getPlaylists() {
        return this.playlists;
    }

    public void setCurrentPlaylist(Playlist playlist) {
        this.current_playlist = playlist;
    }

    public Playlist getCurrentPlaylist() {
        return this.current_playlist;
    }

}
