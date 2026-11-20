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
     * Searches for a song by title using binary search.
     *
     * @param songs the array of songs sorted by title
     * @param songTitle the title to search for
     * @return the matching song, or null if not found
     * @author Niharika
     */
    public static Song searchBySongTitle(Song[] songs, String songTitle) {

        if (songs == null || songTitle == null) {
            return null;
        }

        int low = 0;
        int high = songs.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int comparison = songs[mid].getTitle()
                    .compareToIgnoreCase(songTitle);

            if (comparison == 0) {
                return songs[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
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
