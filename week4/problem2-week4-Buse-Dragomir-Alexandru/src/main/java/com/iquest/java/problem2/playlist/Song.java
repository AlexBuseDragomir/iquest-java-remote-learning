package com.iquest.java.problem2.playlist;

public class Song {

    private String title;
    private String genre;
    private int lengthInSeconds;

    public Song(String title, String genre, int lengthInSeconds) {
        this.title = title;
        this.genre = genre;
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getLengthInSeconds() {
        return this.lengthInSeconds;
    }

    @Override
    public String toString() {
        return "Song " + this.title + "(" + this.genre + ") has a length of " +
                this.lengthInSeconds + " seconds";
    }
}
