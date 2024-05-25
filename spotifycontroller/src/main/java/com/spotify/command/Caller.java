package com.spotify.command;

import java.io.IOException;

import com.spotify.control.Context;
import com.spotify.data.Log;
import com.spotify.rest.ResponseCodes;

public class Caller {

    public Log callCommand(Command command, Context context, int attempts) {

        ResponseCodes response = ResponseCodes.UNKNOWN_ERROR;

        try {
            response = command.execute(context);
        } catch (IOException e) {
            response = ResponseCodes.IO_EXCEPTION;
        } catch (InterruptedException e) {
            response = ResponseCodes.INTERRUPTED_EXCEPTION;
        }

        switch (response) {

            case REAUTHENTICATE:
                return new Log(
                    response, 
                    "Unauthorized - The request requires user authentication or, if the request included authorization credentials, authorization has been refused for those credentials."
                );
            
            case RATE_LIMIT:
                return new Log(
                    response, 
                    "Too Many Requests - Rate limiting has been applied."
                );

            case IO_EXCEPTION:
                return new Log(
                    response, 
                    "Standard Java Exception"
                );

            case INTERRUPTED_EXCEPTION:
                return new Log(
                    response, 
                    "Standard Java Exception"
                );

            case BAD_REQUEST:
                return new Log(
                    response, 
                    "Bad Request - The request could not be understood by the server due to malformed syntax. The message body will contain more information"
                );

            case NOT_FOUND:
                return new Log(
                    response, 
                    "Not Found - The requested resource could not be found. This error can be due to a temporary or permanent condition."
                );

            case SERVICE_CURRENTLY_DOWN:
                return new Log(
                    response, 
                    "Service Unavailable - The server is currently unable to handle the request due to a temporary condition which will be alleviated after some delay. You can choose to resend the request again."
                );
            
            case FORBIDDEN:
                return new Log(
                    response, 
                    "Forbidden - The server understood the request, but is refusing to fulfill it."
                );
                
            case UNKNOWN_ERROR:
                return new Log(
                    response, 
                    "Unknown Error"
                );
            
            case NO_ERROR:
                return new Log(
                    response, 
                    "OK - The request has succeeded. The client can read the result of the request in the body and the headers of the response."
                );

        }

        return new Log(ResponseCodes.UNKNOWN_ERROR, "Unknown Error");

    }
}
