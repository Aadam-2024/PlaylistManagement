    package business;

    import java.util.Arrays;
    import java.util.Objects;

    public class Song {
        private String title;
        private String artist;
        private String album;
        private double rating;
        private String genre;
        private String [] tags;
        private int tagCount;

        public Song(String title, String artist, String album, double rating, String genre, String[] tags) {
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.rating = rating;
            this.genre = genre;
            this.tags = tags;
            this.tagCount = tags.length;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String[] getTags() {
            return tags;
        }

        // You may not add the setTags method

        public int getTagCount() {
            return tagCount;
        }

        public void setTagCount(int tagCount) {
            this.tagCount = tagCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Song song = (Song) o;
            return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(album, song.album);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, artist, album);
        }

        @Override
        public String toString() {
            return "Song{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", album='" + album + '\'' +
                    ", rating=" + rating +
                    ", genre='" + genre + '\'' +
                    ", tags=" + Arrays.toString(tags) +
                    ", tagCount=" + tagCount +
                    '}';
        }

        /**
         * Adds a new tag in alphabetical order without duplicates.
         *
         * @param tag the tag to add
         * @return true if the tag was added, otherwise false
         * @author Niharika
         */
        public boolean addTag(String tag) {

            if (tag == null || tag.trim().isEmpty()) {
                return false;
            }

            // Check whether the tag already exists
            if (containsTag(tag)) {
                return false;
            }

            // Create a new array with space for the additional tag
            String[] newTags = new String[tagCount + 1];

            int i = 0;

            // Find the correct alphabetical position
            while (i < tagCount &&
                    tags[i].compareToIgnoreCase(tag) < 0) {

                newTags[i] = tags[i];
                i++;
            }

            // Insert the new tag
            newTags[i] = tag;

            // Copy the remaining tags
            for (int j = i; j < tagCount; j++) {
                newTags[j + 1] = tags[j];
            }

            tags = newTags;
            tagCount++;

            return true;
        }

        public boolean removeTag(String tag){
            // todo: ADD removeTag() LOGIC
            // Should implement APPROPRIATE delete action
            // Question to ask yourself: Which is more appropriate here - overwrite or shift?
            throw new UnsupportedOperationException("Not implemented yet");
        }

        /**
         * Searches for a tag using binary search.
         *
         * @param tag the tag to search for
         * @return true if the tag exists, otherwise false
         * @author Niharika
         */
        public boolean containsTag(String tag) {

            if (tag == null) {
                return false;
            }

            // Sort tags alphabetically, ignoring case
            for (int i = 1; i < tagCount; i++) {

                String currentTag = tags[i];
                int j = i - 1;

                while (j >= 0 && tags[j].compareToIgnoreCase(currentTag) > 0) {
                    tags[j + 1] = tags[j];
                    j--;
                }

                tags[j + 1] = currentTag;
            }

            // Binary search
            int low = 0;
            int high = tagCount - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                int comparison = tags[mid].compareToIgnoreCase(tag);

                if (comparison == 0) {
                    return true;
                } else if (comparison < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return false;
        }

        public String format(){
            // todo: ADD format() LOGIC
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }
