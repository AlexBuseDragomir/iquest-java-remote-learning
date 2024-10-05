package com.iquest.java.problem2.main;

import com.iquest.java.problem2.context.ThreadRaceContext;

public class MainLauncher {

    public static void main(String[] args) {

        ThreadRaceContext threadRaceContext = new ThreadRaceContext();
        Thread mainThread = new Thread(threadRaceContext);
        mainThread.start();
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("End of program");
    }
}
