package com.iquest.java.problem2.main;

import com.iquest.java.problem2.exception.InvalidClassInputException;
import com.iquest.java.problem2.factory.CustomProxyFactory;
import com.iquest.java.problem2.game.Game;
import com.iquest.java.problem2.game.RtsGame;

public class MainLauncher {

    @SuppressWarnings("TryWithIdenticalCatches")
    public static void main(String[] args) {

        try {
            Game proxy = (Game) CustomProxyFactory.getNewCustomProxyInstance(Game.class, RtsGame.class);
            proxy.play("Starcraft Broodwar");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvalidClassInputException e) {
            e.printStackTrace();
        }
    }
}
