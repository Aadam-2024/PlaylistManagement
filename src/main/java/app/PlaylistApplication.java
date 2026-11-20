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
                    SongUtils.sortSongsByNumTags(songs);

                    for (Song song : songs) {
                        System.out.println("--------------------");
                        System.out.println(song.format());
                    }

                    System.out.println("--------------------");
                    break;

                case "4":
                    System.out.print("Enter a tag to search for: ");
                    String tag = input.nextLine();

                    Song[] matchingSongs = SongUtils.searchByTag(songs, tag);

                    if (matchingSongs.length == 0) {
                        System.out.println("No songs found with that tag.");
                    } else {
                        System.out.println("Songs containing tag: " + tag);

                        for (Song song : matchingSongs) {
                            System.out.println("--------------------");
                            System.out.println(song.format());
                        }

                        System.out.println("--------------------");
                    }
                    break;

                case "5":
                    System.out.print("Enter the song title to search for: ");
                    String songTitle = input.nextLine();

                    // Sort songs before performing binary search
                    SongUtils.sortSongsBySongTitle(songs);

                    Song foundSong = SongUtils.searchBySongTitle(songs, songTitle);

                    if (foundSong == null) {
                        System.out.println("Song not found.");
                    } else {
                        System.out.println("Song found:");
                        System.out.println("--------------------");
                        System.out.println(foundSong.format());
                        System.out.println("--------------------");
                    }
                    break;

                case "6":
                    System.out.print("Enter the song title: ");
                    String titleToEdit = input.nextLine();

                    // Sort songs before performing binary search
                    SongUtils.sortSongsBySongTitle(songs);

                    Song songToEdit = SongUtils.searchBySongTitle(songs, titleToEdit);

                    if (songToEdit == null) {
                        System.out.println("Song not found.");
                    } else {
                        System.out.print("Enter the new tag: ");
                        String newTag = input.nextLine();

                        if (songToEdit.addTag(newTag)) {
                            System.out.println("Tag added successfully.");
                            System.out.println(songToEdit.format());
                        } else {
                            System.out.println("Tag could not be added. It may already exist or be invalid.");
                        }
                    }
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
