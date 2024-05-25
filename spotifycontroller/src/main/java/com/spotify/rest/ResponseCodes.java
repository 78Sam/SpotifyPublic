package com.spotify.rest;

public enum ResponseCodes {
    NO_ERROR, // 200, 201, 202, 203, 204
    REAUTHENTICATE, // 401
    RATE_LIMIT, // 429
    UNKNOWN_ERROR,
    IO_EXCEPTION,
    INTERRUPTED_EXCEPTION,
    SERVICE_CURRENTLY_DOWN, // 503
    BAD_REQUEST, // 400
    NOT_FOUND, // 404
    FORBIDDEN, // 403
}
