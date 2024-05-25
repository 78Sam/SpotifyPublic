package com.spotify.control;

import java.net.http.HttpClient;

import com.spotify.auth.Authenticator;
import com.spotify.data.SpotifyClient;
import com.spotify.playback.CurrentPlayback;
import com.spotify.rest.Builders;
import com.spotify.rest.ResponseHandler;

public class Context {

    private final SpotifyClient spotify_client;
    private final HttpClient http_client;
    private Authenticator authenticator;
    private final Builders builders;
    private final ResponseHandler response_handler;
    private String temp_data;

    public Context(SpotifyClient spotify_client, HttpClient http_client, CurrentPlayback current_playback, Builders builders, ResponseHandler response_handler) {
        this.spotify_client = spotify_client;
        this.http_client = http_client;
        this.builders = builders;
        this.response_handler = response_handler;
    }

    public void addAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public SpotifyClient getSpotifyClient() {
        return this.spotify_client;
    }


    public HttpClient getHttpClient() {
        return this.http_client;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public Builders getBuilders() {
        return this.builders;
    }

    public ResponseHandler getResponseHandler() {
        return this.response_handler;
    }

    public void setTempData(String temp_data) {
        this.temp_data = temp_data;
    }

    public String getTempData() {
        return this.temp_data;
    }

}
