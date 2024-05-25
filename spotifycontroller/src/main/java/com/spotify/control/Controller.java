package com.spotify.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

import com.spotify.command.Caller;
import com.spotify.command.GetAvailableDevicesCommand;
import com.spotify.command.GetPlaybackStateCommand;
import com.spotify.command.GetUserPlaylistsCommand;
import com.spotify.command.PauseCommand;
import com.spotify.command.PlayCommand;
import com.spotify.command.PlayTrackCommand;
import com.spotify.command.PreviousTrackCommand;
import com.spotify.command.SkipTrackCommand;
import com.spotify.command.GetPlaylistCommand;
import com.spotify.data.Log;
import com.spotify.data.playlists.Item;
import com.spotify.data.playlists.Playlists;
import com.spotify.data.playlists.playlist.PlaylistItem;
import com.spotify.data.playlists.playlist.Track;
import com.spotify.playback.Artist;

public class Controller {

    private final Context context;
    private final Scanner scanner;
    private final Caller caller;
    private final Logger logger;

    public Controller(Context context, Scanner scanner, Caller caller) {
        this.context = context;
        this.scanner = scanner;
        this.caller = caller;
        this.logger = Logger.getLogger(Controller.class.getName());
    }

    private void flushScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    private void logAction(String command, Log result) {
        String msg = "\tCommand:" + command + "\n\t" + result.getCode() + "\n\t" + result.getDescription() + "\n";
        this.logger.log(Level.INFO, msg);
    }

    private void getCurrentPlayback() {
        Log result = this.caller.callCommand(new GetPlaybackStateCommand(), context, 0);
        this.logAction("Playback", result);
    }

    private int optionSelect(ArrayList<Integer> options, String message) {

        int input = 0;
        while (!options.contains(input)) {
            System.out.println(message);
            try {
                input = this.scanner.nextInt();
            } catch (InputMismatchException e) {
                this.scanner.nextLine();
            }
            this.flushScreen();
        }

        return input;
    }

    private void pickTrack() {

        int input = 0;

        int i = 1;
        String message = "";
        ArrayList<Integer> options = new ArrayList<>();
        for (PlaylistItem paylist_item : this.context.getSpotifyClient().getCurrentPlaylist().getItems()) {
            options.add(i);
            message = message + i + ": " + paylist_item.getTrack().getName() + "\n";
            i++;
        }

        options.add(-1);
        message = message + "-1: Back";

        while (input != -1) {
        
            input = this.optionSelect(options, message);

            if (input != -1) {
                String track_id = this.context.getSpotifyClient().getCurrentPlaylist().getItems().get(input-1).getTrack().getId();
                context.setTempData(track_id);

                Log result = null;
                result = this.caller.callCommand(new PlayTrackCommand(), context, input);
                this.logAction("PlayTrack", result);
            }

        }

    }

    private void browseLibrary() {

        int input = 0;

        this.getCurrentPlayback();
        Log result = null;
        result = this.caller.callCommand(new GetUserPlaylistsCommand(), context, 0);
        this.logAction("AllPlaylists", result);

        List<Item> playlists = this.context.getSpotifyClient().getPlaylists().getItems();

        int i = 1;
        String message = "";
        ArrayList<Integer> options = new ArrayList<>();

        for (Item playlist : playlists) {
            options.add(i);
            message = message + i + ": " + playlist.getName() + "\n";
            i++;
        }

        options.add(-1);
        message = message + "-1: Back";

        while (input != -1) {
    
            input = this.optionSelect(options, message);

            if (input != -1) {
                Item item = context.getSpotifyClient().getPlaylists().getItems().get(input-1);
    
                context.setTempData(item.getId());
        
                result = null;
                result = this.caller.callCommand(new GetPlaylistCommand(), context, input);
                this.logAction("SpecificPlaylist", result);
        
                this.pickTrack();
            }

        }

    }

    private void controlPlayback() {

        int input = 0;

        Log result = null;
        String command = "Unknown";

        while (input != -1) {

            input = this.optionSelect(
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, -1)),
                "1: Play\n2: Pause\n3: Skip\n4: Previous\n-1: Back"
            );

            result = null;
            command = "Unknown";

            this.getCurrentPlayback();
    
            switch (input) {
                case 1:
                    command = "Play";
                    result = this.caller.callCommand(new PlayCommand(), context, 0);
                    break;
                
                case 2:
                    command = "Pause";
                    result = this.caller.callCommand(new PauseCommand(), context, 0);
                    break;
    
                case 3:
                    command = "Skip";
                    result = this.caller.callCommand(new SkipTrackCommand(), context, 0);
                    break;
    
                case 4:
                    command = "Previous";
                    result = this.caller.callCommand(new PreviousTrackCommand(), context, 0);
                    break;
                
                case -1:
                    break;
            
                default:
                    break;
            }

            if (input != -1 && input != 0 && result != null) {
                this.logAction(command, result);
            }

        }

    }

    public void mainMenu() {

        int input = 0;

        while (input != -1) {

            input = this.optionSelect(
                new ArrayList<Integer>(Arrays.asList(1, 2, -1)), 
                "1: Control Playback\n2: Browse Library\n-1: Quit"
            );
    
            switch (input) {
                case 1:
                    this.controlPlayback();
                    break;
                
                case 2:
                    this.browseLibrary();
                    break;
                
                case -1:
                    break;
            
                default:
                    break;
            }

        }

    }

    public int executeUserCommand() {

        System.out.println("Enter a command:\n1: Play\n2: Pause\n3: Skip\n4: previous\n-1: End");

        int input = 0;

        try {
            input = this.scanner.nextInt();
        } catch (InputMismatchException e) {
            this.scanner.nextLine();
            System.out.println("Please enter a valid value");
        }

        this.flushScreen();
        this.getCurrentPlayback();

        Log result = null;
        String command = "Unknown";
        
        switch (input) {
            
            case 1:
                command = "Play";
                result = this.caller.callCommand(new PlayCommand(), context, 0);
                break;
            case 2:
                command = "Pause";
                result = this.caller.callCommand(new PauseCommand(), context, 0);
                break;
            case 3:
                command = "Skip";
                result = this.caller.callCommand(new SkipTrackCommand(), context, 0);
                break;
            case 4:
                command = "Previous";
                result = this.caller.callCommand(new PreviousTrackCommand(), context, 0);
                break;
            case 5:
                command = "Playback";
                // System.out.println("\nCalling get playback state command:");
                // System.out.println(this.context.getSpotifyClient().getCurrentPlayback().getItem().getName());
                // List<Artist> artists = this.context.getSpotifyClient().getCurrentPlayback().getItem().getArtists();
                // for (Artist artist : artists) {
                //     System.out.println(artist.getName());
                // }
            case 6:
                command = "Devices";
                System.out.println("\nCalling available devices track command:");
                result = this.caller.callCommand(new GetAvailableDevicesCommand(), context, 0);
                break;
            case 7:
                command = "Playlists";
                result = this.caller.callCommand(new GetUserPlaylistsCommand(), context, 0);
                int i = 0;
                for (Item item : context.getSpotifyClient().getPlaylists().getItems()) {
                    System.out.println(i + ": " + item.getName());
                    i++;
                }

                System.out.println("Enter a playlist name");
                int playlist_choice = this.scanner.nextInt();
                Item item = context.getSpotifyClient().getPlaylists().getItems().get(playlist_choice);

                context.setTempData(item.getId());
                this.caller.callCommand(new GetPlaylistCommand(), context, input);


                for (PlaylistItem paylist_item : context.getSpotifyClient().getCurrentPlaylist().getItems()) {
                    Track track = paylist_item.getTrack();
                    System.out.println(track.getName());
                }

                input = 7;
                break;
            case 0: // Called on mis-input from cmd
                break;
            case -1:
                break;
        
        }

        if (input != -1 && input != 0 && result != null) {
            this.logAction(command, result);
        }

        return input;

    }

}
