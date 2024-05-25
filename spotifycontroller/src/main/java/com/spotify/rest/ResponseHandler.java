package com.spotify.rest;

import java.net.http.HttpResponse;

public class ResponseHandler {

    public ResponseCodes handleResponse(HttpResponse<String> response) {
        
        int code = response.statusCode();
        
        switch (code) {
            case 200:
                return ResponseCodes.NO_ERROR;
            case 201:
                return ResponseCodes.NO_ERROR;
            case 202:
                return ResponseCodes.NO_ERROR;
            case 203:
                return ResponseCodes.NO_ERROR;
            case 204:
                return ResponseCodes.NO_ERROR;
            case 400:
                return ResponseCodes.BAD_REQUEST;
            case 401:
                return ResponseCodes.REAUTHENTICATE;
            case 403:
                return ResponseCodes.FORBIDDEN;
            case 404:
                return ResponseCodes.NOT_FOUND;
            case 429:
                return ResponseCodes.RATE_LIMIT;
            case 503:
                return ResponseCodes.SERVICE_CURRENTLY_DOWN;
        }

        return ResponseCodes.UNKNOWN_ERROR;
    }

    public Boolean isOk(HttpResponse<String> response) {

        int code = response.statusCode();
        
        switch (code) {
            case 200:
                return true;
            case 201:
                return true;
            case 202:
                return true;
            case 203:
                return true;
            case 204:
                return true;
            case 400:
                return false;
            case 401:
                return false;
            case 403:
                return false;
            case 404:
                return false;
            case 429:
                return false;
            case 503:
                return false;
        }

        return false;

    }
}
