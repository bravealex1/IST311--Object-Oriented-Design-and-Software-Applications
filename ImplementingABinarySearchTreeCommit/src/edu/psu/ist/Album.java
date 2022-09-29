package edu.psu.ist;

import java.util.ArrayList;

public class Album implements Comparable <Album> {
    private int numericalID;
    ArrayList<String> artistName;
    String title;
    Integer numOfSongs;

    public Album(int numericalID, ArrayList<String> artistName, int numOfSongs, String title) {
        this.numericalID = numericalID;
        this.numOfSongs = numOfSongs;
        this.artistName = artistName;
        this.title = title;
    }

    @Override
    public int compareTo(Album album) {
        if(this.numOfSongs == album.numOfSongs) {
            return 0;
        }
        else if(this.numOfSongs > album.numOfSongs) {
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.numericalID + ":" + " -- " + this.artistName + " -- " + this.numOfSongs;
    }
}
