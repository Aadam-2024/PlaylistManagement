package app;

import business.Song;
import utils.SongFileUtils;
import utils.SongUtils;
import java.util.Scanner;

/**
 * Playlist management console application.
 * Complete the menu actions to meet the requirements in the CA7 brief.
 */
public class PlaylistApplication {
    /**
     * Reads the supplied song file and runs the playlist menu.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Song[] songs = SongFileUtils.readSongFile("sampleSongInput.txt");
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    if (songs.length == 0) {
                        System.out.println("No songs found in the playlist.");
                    } else {
                        for (Song song : songs) {
                            System.out.println("--------------------");
                            System.out.println(song.format());
                        }
                        System.out.println("--------------------");
                    }
                    break;

                case "2":
                    SongUtils.sortSongsBySongTitle(songs);

                    for (Song song : songs) {
                        System.out.println("--------------------");
                        System.out.println(song.format());
                    }

                    System.out.println("--------------------");
                    break;

                case "3":
                    // Student B: sort by number of tags and display the playlist.
                    break;
                case "4":
                    // Student A: search for songs with a specified tag and display matches.
                    break;
                case "5":
                    // Student B: sort by title before searching for a song by title.
                    break;
                case "6":
                    // Student A: select a song and add a tag.
                    break;
                case "7":
                    // Student B: select a song and remove a tag.
                    break;
                case "8":
                    // Student A: find and display the most popular song.
                    break;
                case "9":
                    // Student B: supply candidate tags and find the most common tag.
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
        input.close();
    }

    /** Displays the playlist menu. */
    private static void displayMenu() {
        System.out.println("\nPlaylist Management");
        System.out.println("1) Display all songs");
        System.out.println("2) Sort songs by title");
        System.out.println("3) Sort songs by number of tags");
        System.out.println("4) Search for songs by tag");
        System.out.println("5) Search for a song by title");
        System.out.println("6) Add a tag to a song");
        System.out.println("7) Remove a tag from a song");
        System.out.println("8) Find the most popular song");
        System.out.println("9) Find the most common candidate tag");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");
    }
}
