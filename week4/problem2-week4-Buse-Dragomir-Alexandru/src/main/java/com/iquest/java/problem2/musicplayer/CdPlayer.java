package com.iquest.java.problem2.musicplayer;

import com.iquest.java.problem2.playlist.Playlist;
import com.iquest.java.problem2.playlist.Song;

public class CdPlayer implements MusicPlayer {

    private Playlist playlist;

    public CdPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public void playSong(Song songToPlay) {
        if (playlist.doesContainSong(songToPlay)) {
            System.out.println("CD Player: Currently playing: " + songToPlay);
        } else
        {
            System.err.println("CANNOT PLAY ON CD PLAYER: Song " + songToPlay.getTitle() +
                    " is not currently on the CD Player");
        }
    }

    @Override
    public void pauseSong(Song songToPause) {
        if (playlist.doesContainSong(songToPause)) {
            System.out.println("CD Player: The song " + songToPause.getTitle() +
                    " has been paused");
        } else
        {
            System.err.println("CANNOT PAUSE ON CD PLAYER: Song " + songToPause.getTitle() +
                    " is not currently on the CD Player");
        }
    }
}
