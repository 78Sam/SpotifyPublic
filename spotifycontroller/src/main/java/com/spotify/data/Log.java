package com.spotify.data;

import com.spotify.rest.ResponseCodes;

public class Log {
    private final ResponseCodes code;
    private final String description;

    public Log(ResponseCodes code, String description) {
        this.code = code;
        this.description = description;
    }

    public ResponseCodes getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
