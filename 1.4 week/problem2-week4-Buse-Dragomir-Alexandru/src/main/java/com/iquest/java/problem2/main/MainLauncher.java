package com.iquest.java.problem2.main;

import com.iquest.java.problem2.band.Band;
import com.iquest.java.problem2.instruments.DrumSet;
import com.iquest.java.problem2.instruments.Guitar;
import com.iquest.java.problem2.musicians.drummer.Drummer;
import com.iquest.java.problem2.musicians.guitarist.Guitarist;
import com.iquest.java.problem2.musicians.drummer.JazzDrummer;
import com.iquest.java.problem2.musicians.guitarist.RhythmGuitarist;
import com.iquest.java.problem2.musicplayer.CdPlayer;
import com.iquest.java.problem2.musicplayer.IPad;
import com.iquest.java.problem2.playlist.Playlist;
import com.iquest.java.problem2.playlist.Song;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        Song firstSong = new Song("Ain't No Sunshine", "blues", 190);
        Song secondSong = new Song("Hit the road Jack!", "soul", 140);
        Song thirdSong = new Song("Suspicious Minds", "rock and roll", 260);
        System.out.println(firstSong);
        System.out.println(secondSong);
        System.out.println(thirdSong);
        System.out.println();

        List<Song> songList = new ArrayList<>();
        Playlist playlist = new Playlist(songList);
        System.out.println(playlist);
        playlist.addSongToPlaylist(firstSong);
        playlist.addSongToPlaylist(secondSong);
        playlist.addSongToPlaylist(thirdSong);
        playlist.removeSongFromPlaylist(secondSong);
        System.out.println(playlist);
        System.out.println();

        IPad iPad = new IPad(playlist);
        iPad.playSong(firstSong);
        iPad.pauseSong(firstSong);
        CdPlayer cdPlayer = new CdPlayer(playlist);
        cdPlayer.playSong(secondSong);
        cdPlayer.pauseSong(secondSong);
        System.out.println();

        DrumSet drumSet = new DrumSet("fusion", 2500);
        Guitar guitar = new Guitar("rhythm", "sky blue");
        Guitarist rhythmGuitarist = new RhythmGuitarist("Alan Clark Jr.", guitar);
        Drummer jazzDrummer = new JazzDrummer("Stevie Connely", drumSet);
        rhythmGuitarist.tuneGuitar();
        rhythmGuitarist.playGuitar();
        jazzDrummer.takeSticks();
        jazzDrummer.playDrums();
        System.out.println();

        Band band = new Band(jazzDrummer, rhythmGuitarist);
        System.out.println(band);
        band.performRehearsal();
        band.singAtTheConcert();
    }
}
