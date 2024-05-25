package com.spotify;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Scanner;

import com.spotify.auth.Authenticator;
import com.spotify.command.Caller;
import com.spotify.control.Context;
import com.spotify.control.Controller;
import com.spotify.data.SpotifyClient;
import com.spotify.rest.Builders;
import com.spotify.rest.ResponseHandler;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {

        // TODO: Album Song selector

        Scanner scanner = new Scanner(System.in);

        Caller caller = new Caller();
        Context context = new Context(new SpotifyClient(), HttpClient.newHttpClient(), null, new Builders(), new ResponseHandler());
        Controller controller = new Controller(context, scanner, caller);
        
        Authenticator authenticator = new Authenticator(context, scanner);
        context.addAuthenticator(authenticator);

        context.getAuthenticator().getMainAuth();

        controller.mainMenu();

        scanner.close();

    }
}
