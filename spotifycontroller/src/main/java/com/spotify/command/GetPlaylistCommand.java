package com.spotify.command;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.spotify.control.Context;
import com.spotify.data.playlists.playlist.Playlist;
import com.spotify.rest.ResponseCodes;

public class GetPlaylistCommand implements Command {

    public ResponseCodes execute(Context context) throws IOException, InterruptedException {
        String endpoint = Command.BASE_ENDPOINT + "/playlists/" + context.getTempData() + "/tracks";

        HttpRequest request = context.getBuilders().buildGetRequest(endpoint, context.getSpotifyClient().getAuthToken().getAccessToken());
        HttpResponse<String> response = context.getHttpClient().send(request, BodyHandlers.ofString());

        if (context.getResponseHandler().isOk(response)) {
            Playlist playlist = new Gson().fromJson(response.body(), Playlist.class);
            context.getSpotifyClient().setCurrentPlaylist(playlist);
        }

        return context.getResponseHandler().handleResponse(response);
    }
    
}
