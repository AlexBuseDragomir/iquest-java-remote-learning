package com.iquest.java.problem2.game;

import com.iquest.java.problem2.annotation.Logged;

@Logged
public class RtsGame implements  Game {

    @Override
    @Logged
    public void play(String gameTitle) {
        System.out.println("Playing the RTS game called " + gameTitle);
    }
}
