package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class SongUtils {
    /**
     * Returns every song containing the requested tag (case-insensitive).
     * Use a linear scan and Song.containsTag(); return an empty array if none match.
     */
    public static Song[] searchByTag(Song [] songs, String tag){
        // todo: ADD searchByTag() LOGIC
        // Should implement linear search, but not for a single result
        throw new UnsupportedOperationException("Not implemented yet");
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
