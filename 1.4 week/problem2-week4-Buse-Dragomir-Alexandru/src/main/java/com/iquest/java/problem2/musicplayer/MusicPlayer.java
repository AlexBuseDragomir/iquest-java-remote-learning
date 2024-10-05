package com.iquest.java.problem2.musicplayer;

import com.iquest.java.problem2.playlist.Song;

public interface MusicPlayer {

    void playSong(Song songToPlay);
    void pauseSong(Song songToPause);
}
