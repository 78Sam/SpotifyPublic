package com.spotify.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

public class Builders {

    public HttpRequest buildPostRequest(String endpoint, String header) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .header("Authorization", "Bearer " + header)
            .POST(BodyPublishers.ofString(""))
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildAuthPostRequest(String endpoint) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(BodyPublishers.ofString(""))
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildAuthPostRequest(String endpoint, String auth) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic " + auth)
            .POST(BodyPublishers.ofString(""))
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildPutRequest(String endpoint, String header) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .header("Authorization", "Bearer " + header)
            .PUT(BodyPublishers.ofString(""))
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildPutRequest(String endpoint, String header, String body) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .header("Authorization", "Bearer " + header)
            .header("Content-Type", "application/json")
            .PUT(BodyPublishers.ofString(body))
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildGetRequest(String endpoint, String header) {
        try {
            return HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .header("Authorization", "Bearer " + header)
            .GET()
            .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public HttpRequest buildAuthGetRequest(String endpoint) {
        try {
            return HttpRequest.newBuilder()
                .uri(new URI(endpoint))
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .GET()
                .build();
        } catch (URISyntaxException e) {
            return null;
        }
    }
}
