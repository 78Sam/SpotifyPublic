package com.spotify.auth;

public class AccessToken {

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
    private String refresh_token;

    public AccessToken(String access_token, String token_type, String scope, int expires_in, String refresh_token) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.scope = scope;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
    }

    public String getAccessToken() {
        return this.access_token;
    }

    public String getTokenType() {
        return this.token_type;
    }

    public int getExpiresIn() {
        return this.expires_in;
    }

    public String getScope() {
        return this.scope;
    }

    public String getRefreshToken() {
        return this.refresh_token;
    }

}
