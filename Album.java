
/**
 * Write a description of class Album here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.List;
//Class for an album, stores info on each one.
public class Album implements Comparable<Album> {
  private int id;
  private String title;
  private int numSongs;
  private List<String> artists;
  public Album(int id, String title, int numSongs, List<String> artists) {
    this.id = id;
    this.title = title;
    this.numSongs = numSongs;
    this.artists = artists;
  }
  //get functions for id, title, numSongs, and artists
  public int getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public int getNumSongs() {
    return numSongs;
  }
  public List<String> getArtists() {
    return artists;
  }
  //To string formating
  @Override
  public String toString() {
    return "ID: " + id + " -- " + title + " -- " + numSongs + " -- " + artists;
  }
  //Compare function for numSongs
  public int compareTo(Album o){
    return this.numSongs - o.numSongs;
  }
}
