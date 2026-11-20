package utils;

import business.Song;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michelle
 */
public class SongFileUtils {
    public static Song [] readSongFile(String filename){
        ArrayList<Song> temp = new ArrayList<>();
        
        Scanner inputFile;
        try{
            inputFile = new Scanner(new FileReader(filename));
            while(inputFile.hasNextLine()){
                Song r = parseSong(inputFile.nextLine());
                if(r!= null){
                    temp.add(r);
                }
            }
        } catch (FileNotFoundException ex){
            // This is not the way to handle this issue in proper code!!
            // As you don't know how to recover from exceptions occurring yet, 
            // I just want you to see the error, then have the program end
            Logger.getLogger(SongFileUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occurred when reading from file: " + ex.getMessage());
            ex.printStackTrace();
            // We usually DO NOT WANT TO DO THIS
            System.exit(1);
        }
        Song [] text = new Song[temp.size()];
        return temp.toArray(text);
    }
    
    private static Song parseSong(String s){
        // Format: Title%%Artist%%Album%%Rating%%Genre%%tag1~~tag2~~tag3 etc
        // %% separates components of a song
        // ~~ separates tags
        Song song = null;
        String [] components = s.split("%%");
        if(components.length == 6){
            String title = components[0];
            String artist = components[1];
            String album = components[2];
            double rating;
            try{
                rating = Double.parseDouble(components[3]);
            }catch(NumberFormatException e){
                rating = 0;
            }
            String genre = components[4];
            String [] tagList = components[5].split("~~");

            sortTags(tagList);
            
            song = new Song(title, artist, album, rating, genre, tagList);
        }
        return song;
    }
    
    // Sort imported tags so that binary search can be used on each Song.
    private static void sortTags(String[] tags) {
        for (int i = 1; i < tags.length; i++) {
            String current = tags[i];
            int j = i - 1;
            while (j >= 0 && tags[j].compareToIgnoreCase(current) > 0) {
                tags[j + 1] = tags[j];
                j--;
            }
            tags[j + 1] = current;
        }
    }

    private static String formatSongForFile(Song s){
        if(s == null){
            return null;
        }
        // Format: Title%%Artist%%Album%%Rating%%Genre%%tag1~~tag2~~tag3 etc
        // %% separates components of a song
        // ~~ separates tags
        // Build start of String
        String output = s.getTitle()+"%%" + s.getArtist()+"%%" + s.getAlbum() + "%%" + s.getRating()+"%%"+s.getGenre()+
                "%%";
        
        // Handle tags
        String [] tags = s.getTags();
        String tagsList;
        if(tags.length > 0){
            tagsList = tags[0];
            for(int i = 1; i < tags.length; i++){
                tagsList = tagsList + "~~" + tags[i];
            }
        }else{
            tagsList = "";
        }
        
        output = output + tagsList;
        
        return output;
    }

    public static void main(String[] args) {
        Song[] songs = readSongFile("sampleSongInput.txt");
        for(Song s: songs){
                System.out.println("-----------------");
        }
    }
}
