package com.spotify.auth;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.spotify.control.Context;
import com.spotify.data.SpotifyClient;
import com.spotify.rest.Builders;

import java.util.Base64;
import java.util.Scanner;

public class Authenticator {

    private static final String ACCOUNTS_ENDPOINT = "https://accounts.spotify.com";
    private static final String TOKEN_ENDPOINT = "/api/token";

    private final HttpClient http_client = HttpClient.newHttpClient();
    private final SpotifyClient spotify_client;
    private final Builders builders;

    private Scanner scanner;

    public Authenticator(Context context, Scanner scanner) {
        this.spotify_client = context.getSpotifyClient();
        this.builders = context.getBuilders();
        this.scanner = scanner;
    }

    private void setAuthToken(CallbackCode code, String redirect) throws IOException, InterruptedException {
        String endpoint =
            ACCOUNTS_ENDPOINT +
            TOKEN_ENDPOINT +
            "?grant_type=authorization_code" +
            "&code=" + code.getCode() +
            "&redirect_uri=" + redirect;

        Base64.Encoder encoder = Base64.getEncoder();
        String base_client = encoder.encodeToString((this.spotify_client.getClientID() + ":" + this.spotify_client.getClientSecret()).getBytes());

        HttpRequest request = this.builders.buildAuthPostRequest(endpoint, base_client);
        HttpResponse<String> response = this.http_client.send(request, BodyHandlers.ofString());

        AccessToken token = new Gson().fromJson(response.body(), AccessToken.class);

        this.spotify_client.setAuthToken(token);
    }

    private void refreshAuthToken(String code) throws IOException, InterruptedException {
        String endpoint =
            ACCOUNTS_ENDPOINT +
            TOKEN_ENDPOINT +
            "?grant_type=refresh_token" +
            "&refresh_token=" + code;

        Base64.Encoder encoder = Base64.getEncoder();
        String base_client = encoder.encodeToString((this.spotify_client.getClientID() + ":" + this.spotify_client.getClientSecret()).getBytes());

        HttpRequest request = this.builders.buildAuthPostRequest(endpoint, base_client);
        HttpResponse<String> response = this.http_client.send(request, BodyHandlers.ofString());

        AccessToken token = new Gson().fromJson(response.body(), AccessToken.class);

        this.spotify_client.setAuthToken(token);
        this.writeAuthCode(new File("code.txt"));
    }

    private String readAuthCode(File file) throws FileNotFoundException {
        Scanner file_reader = new Scanner(file);
        String code = null;

        if (file_reader.hasNextLine()) {
            code = file_reader.nextLine();
        }

        file_reader.close();
        return code;
    }

    private void writeAuthCode(File file) throws IOException {
        if (file.createNewFile()) {
            FileWriter writer = new FileWriter(file);
            writer.write(this.spotify_client.getAuthToken().getRefreshToken());
            writer.close();
        }
    }

    private void retrieveAuthCode(String redirect, Boolean retry) throws IOException, InterruptedException {

        if (retry) {
            System.out.println("\nFailed, Enter the one time code: ");
        } else {
            System.out.println("\nEnter the one time code: ");
        }

        String state = this.scanner.nextLine();

        while (!state.matches("[A-Z0-9]{6}")) {
            System.out.println("\nIncorrect Code Format, Enter the one time code: ");
            state = this.scanner.nextLine();
        }

        String endpoint = "https://sam-mccormack.co.uk/Spotify/getcode.php?state=" + state;

        HttpRequest request = this.builders.buildAuthGetRequest(endpoint);
        HttpResponse<String> response = this.http_client.send(request, BodyHandlers.ofString());

        CallbackCode code = new Gson().fromJson(response.body(), CallbackCode.class);

        if (code.getCode() == null) {
            this.retrieveAuthCode(redirect, true);
        } else {
            this.setAuthToken(code, redirect);
        }

    }

    public void getMainAuth() throws IOException, InterruptedException {

        File file = new File("code.txt");

        if (file.exists() && !file.isDirectory()) {
            String code = this.readAuthCode(file);
            this.refreshAuthToken(code);
        } else {
            String redirect = "https://sam-mccormack.co.uk/Spotify/callback.php";

            System.out.println("Please go to: https://sam-mccormack.co.uk/Spotify\n");

            this.retrieveAuthCode(redirect, false);
            this.writeAuthCode(file);
            
        }
    }

}
