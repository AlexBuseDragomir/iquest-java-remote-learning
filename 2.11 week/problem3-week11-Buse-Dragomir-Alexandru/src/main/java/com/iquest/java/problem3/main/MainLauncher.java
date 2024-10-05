package com.iquest.java.problem3.main;

import com.iquest.java.problem3.context.ThreadRaceContext;

public class MainLauncher {

    public static void main(String[] args) {

        ThreadRaceContext threadRaceContext = new ThreadRaceContext();
        new Thread(threadRaceContext).start();
    }
}
