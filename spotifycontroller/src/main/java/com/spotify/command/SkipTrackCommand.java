package com.spotify.command;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.spotify.control.Context;
import com.spotify.rest.ResponseCodes;

public class SkipTrackCommand implements Command {

    @Override
    public ResponseCodes execute(Context context)
            throws IOException, InterruptedException {

        String endpoint = Command.PLAYER_ENDPOINT + "/player/next";

        HttpRequest request = context.getBuilders().buildPostRequest(endpoint, context.getSpotifyClient().getAuthToken().getAccessToken());
        HttpResponse<String> response = context.getHttpClient().send(request, BodyHandlers.ofString());

        return context.getResponseHandler().handleResponse(response);
    }
    
}
