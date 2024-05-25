package com.spotify.command;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.spotify.control.Context;
import com.spotify.playback.Devices;
import com.spotify.rest.ResponseCodes;

public class GetAvailableDevicesCommand implements Command {

    @Override
    public ResponseCodes execute(Context context) throws IOException, InterruptedException {
        String endpoint = Command.PLAYER_ENDPOINT + "/player/devices";

        HttpRequest request = context.getBuilders().buildGetRequest(endpoint, context.getSpotifyClient().getAuthToken().getAccessToken());
        HttpResponse<String> response = context.getHttpClient().send(request, BodyHandlers.ofString());

        if (context.getResponseHandler().isOk(response)) {
            Devices devices = new Gson().fromJson(response.body(), Devices.class);
            context.getSpotifyClient().setDevices(devices);
        }

        // System.out.println(response.headers());
        // System.out.println(response.body());

        return context.getResponseHandler().handleResponse(response);
    }
    
}
