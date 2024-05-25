package com.spotify.command;

import java.io.IOException;

import com.spotify.control.Context;
import com.spotify.rest.ResponseCodes;

public interface Command {

    public static final String BASE_ENDPOINT = "https://api.spotify.com/v1";

    public static final String PLAYER_ENDPOINT = "https://api.spotify.com/v1/me";
    
    public ResponseCodes execute(Context context) throws IOException, InterruptedException;

}
