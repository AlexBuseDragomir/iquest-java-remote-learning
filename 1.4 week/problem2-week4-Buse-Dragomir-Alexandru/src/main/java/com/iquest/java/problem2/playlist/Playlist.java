package com.iquest.java.problem2.playlist;

import java.util.List;

public class Playlist {

    private List<Song> songList;

    public Playlist(List<Song> songList) {
        this.songList = songList;
    }

    public boolean doesContainSong(Song searchedSong) {
        return this.songList.contains(searchedSong);
    }

    public void addSongToPlaylist(Song newSong) {
        if (this.songList.contains(newSong)) {
            System.err.println("ERROR WHILE ADDING: Song has been already added to the playlist");
        } else {
            this.songList.add(newSong);
            System.out.println("A song has been added to the playlist");
        }
    }

    public void removeSongFromPlaylist(Song songToRemove) {
        if ( ! this.songList.contains(songToRemove)) {
            System.err.println("ERROR WHILE REMOVING: Song is no longer in the playlist");
        } else {
            this.songList.remove(songToRemove);
            System.out.println("A song has been removed from the playlist");
        }
    }

    private int getNumberOfSongsOnPlaylist() {
        return this.songList.size();
    }

    @Override
    public String toString() {
        int numberOfSongs = this.getNumberOfSongsOnPlaylist();
        return "Playlist contains " + numberOfSongs + " songs";
    }
}
