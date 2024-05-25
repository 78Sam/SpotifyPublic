package com.spotify.auth;

public class CallbackCode {
    private final String code;
    private final String state;

    public CallbackCode(String code, String state) {
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return this.code;
    }

    public String getState() {
        return this.state;
    }
}
