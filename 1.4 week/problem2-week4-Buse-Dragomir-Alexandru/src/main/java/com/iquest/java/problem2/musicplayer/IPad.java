package com.iquest.java.problem2.musicplayer;

import com.iquest.java.problem2.playlist.Playlist;
import com.iquest.java.problem2.playlist.Song;

public class IPad implements MusicPlayer {

    private Playlist playlist;

    public IPad(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public void playSong(Song songToPlay) {
        if (playlist.doesContainSong(songToPlay)) {
            System.out.println("iPad: Currently playing: " + songToPlay);
        } else
        {
            System.err.println("CANNOT PLAY ON iPad: Song " + songToPlay.getTitle() +
                    " is not currently on the iPad");
        }
    }

    @Override
    public void pauseSong(Song songToPause) {
        if (playlist.doesContainSong(songToPause)) {
            System.out.println("iPad: The song " + songToPause.getTitle() +
                    " has been paused");
        } else
        {
            System.err.println("CANNOT PAUSE ON iPad: Song " + songToPause.getTitle() +
                    " is not currently on the iPad");
        }
    }
}
