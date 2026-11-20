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

    /**
     * Finds the song with the highest rating.
     *
     * @param songs the array of songs to search
     * @return the most popular song, or null if the array is empty
     * @author Niharika
     */
    public static Song findMostPopular(Song[] songs) {

        if (songs == null || songs.length == 0) {
            return null;
        }

        Song mostPopular = null;

        // Find the song with the highest rating
        for (int i = 0; i < songs.length; i++) {

            if (songs[i] != null) {

                if (mostPopular == null ||
                        songs[i].getRating() > mostPopular.getRating()) {

                    mostPopular = songs[i];
                }
            }
        }

        return mostPopular;
    }

    /**
     * Sorts songs alphabetically by title using Bubble Sort.
     *
     * @param songs the array of songs to sort
     * @author Niharika
     */
    public static void sortSongsBySongTitle(Song[] songs) {

        if (songs == null || songs.length < 2) {
            return;
        }

        // Bubble Sort
        for (int i = 0; i < songs.length - 1; i++) {

            for (int j = 0; j < songs.length - 1 - i; j++) {

                if (songs[j].getTitle()
                        .compareToIgnoreCase(songs[j + 1].getTitle()) > 0) {

                    // Swap the two songs
                    Song temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Sorts songs by number of tags in descending order using Selection Sort.
     *
     * @param songs the array of songs to sort
     * @author Niharika
     */
    public static void sortSongsByNumTags(Song[] songs) {

        if (songs == null || songs.length < 2) {
            return;
        }

        // Selection Sort
        for (int i = 0; i < songs.length - 1; i++) {

            int maxIndex = i;

            // Find the song with the highest number of tags
            for (int j = i + 1; j < songs.length; j++) {

                if (songs[j].getTagCount() >
                        songs[maxIndex].getTagCount()) {

                    maxIndex = j;
                }
            }

            // Swap the songs
            if (maxIndex != i) {

                Song temp = songs[i];
                songs[i] = songs[maxIndex];
                songs[maxIndex] = temp;
            }
        }
    }

    /**
     * Finds the most common candidate tag across all songs.
     * Ignores case and returns the last candidate in case of a tie.
     *
     * @param songs the array of songs to search
     * @param candidateTags the candidate tags to compare
     * @return the most common tag, or null if none are found
     * @author Niharika
     */
    public static String findMostCommonTag(Song[] songs, String[] candidateTags) {

        if (songs == null || candidateTags == null) {
            return null;
        }

        String mostCommonTag = null;
        int highestCount = 0;

        // Check each candidate tag
        for (int i = 0; i < candidateTags.length; i++) {

            if (candidateTags[i] == null) {
                continue;
            }

            int count = 0;

            // Count how many songs contain this tag
            for (int j = 0; j < songs.length; j++) {

                if (songs[j] != null &&
                        songs[j].containsTag(candidateTags[i])) {
                    count++;
                }
            }

            // >= ensures the last candidate wins in a tie
            if (count >= highestCount && count > 0) {
                highestCount = count;
                mostCommonTag = candidateTags[i];
            }
        }

        return mostCommonTag;
    }
}
