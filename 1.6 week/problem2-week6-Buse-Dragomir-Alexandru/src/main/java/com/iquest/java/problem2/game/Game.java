package com.iquest.java.problem2.game;

import com.iquest.java.problem2.annotation.Logged;

@Logged
public interface Game {

    @Logged
    void play(String gameTitle);
}
