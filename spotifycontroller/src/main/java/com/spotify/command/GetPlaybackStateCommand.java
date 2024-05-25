package com.spotify.command;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.spotify.control.Context;
import com.spotify.playback.CurrentPlayback;
import com.spotify.rest.ResponseCodes;

public class GetPlaybackStateCommand implements Command{

    @Override
    public ResponseCodes execute(Context context) throws IOException, InterruptedException {

        String endpoint = Command.PLAYER_ENDPOINT + "/player";

        HttpRequest request = context.getBuilders().buildGetRequest(endpoint, context.getSpotifyClient().getAuthToken().getAccessToken());
        HttpResponse<String> response = context.getHttpClient().send(request, BodyHandlers.ofString());

        if (context.getResponseHandler().isOk(response)) {
            CurrentPlayback current_playback = new Gson().fromJson(response.body(), CurrentPlayback.class);
            context.getSpotifyClient().setCurrentPlayback(current_playback);
        }

        return context.getResponseHandler().handleResponse(response);
    }
    
}
