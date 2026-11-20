package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class SongUtils {
    /**
     * Returns every song containing the requested tag.
     *
     * @param songs the array of songs to search
     * @param tag the tag to search for
     * @return an array containing all matching songs
     * @author Niharika
     */
    public static Song[] searchByTag(Song[] songs, String tag) {

        if (songs == null || tag == null) {
            return new Song[0];
        }

        // First pass: count matching songs
        int count = 0;

        for (int i = 0; i < songs.length; i++) {

            if (songs[i] != null && songs[i].containsTag(tag)) {
                count++;
            }
        }

        // Create an array of the exact required size
        Song[] results = new Song[count];

        // Second pass: store matching songs
        int index = 0;

        for (int i = 0; i < songs.length; i++) {

            if (songs[i] != null && songs[i].containsTag(tag)) {
                results[index] = songs[i];
                index++;
            }
        }

        return results;
    }

    /**
     * Binary-searches a song array already sorted by title (case-insensitive).
     * Returns the matching Song, or null if not found.
     */
    public static Song searchBySongTitle(Song [] songs, String songTitle){
        // todo: ADD searchBySongTitle() LOGIC
        // Should implement binary search
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static Song findMostPopular(Song [] songs){
        // todo: ADD findMostPopular() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void sortSongsBySongTitle(Song [] songs){
        // todo: ADD sortSongsBySongTitle() LOGIC
        // Should implement for-loop based bubble sort
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void sortSongsByNumTags(Song [] songs){
        // todo: ADD sortSongsByNumTags() LOGIC
        // Should implement selection sort
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the most frequently occurring candidate tag across the songs.
     * Ignore case; break ties in favour of the LAST candidate; return null if none match.
     */
    public static String findMostCommonTag(Song [] songs, String[] candidateTags){
        // todo: ADD findMostCommonTag() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
