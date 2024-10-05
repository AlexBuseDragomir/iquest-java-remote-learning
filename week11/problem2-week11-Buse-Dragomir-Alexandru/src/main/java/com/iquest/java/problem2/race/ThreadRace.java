package com.iquest.java.problem2.race;

import com.iquest.java.problem2.competitor.ThreadRaceCompetitor;
import com.iquest.java.problem2.context.ThreadRaceContext;

import java.util.ArrayList;
import java.util.List;

public class ThreadRace implements Runnable {

    private final static int NUMBER_OF_COMPETITORS = 10;
    private ThreadRaceContext threadRaceContext;
    private List<Thread> competitors;

    public ThreadRace(ThreadRaceContext threadRaceContext) {
        this.threadRaceContext = threadRaceContext;
        this.competitors = new ArrayList<>();
    }

    public int getNumberOfCompetitors() {
        return NUMBER_OF_COMPETITORS;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_COMPETITORS; i ++) {
            ThreadRaceCompetitor competitor = new ThreadRaceCompetitor(i + 1, this.threadRaceContext);
            Thread newCompetitor = new Thread(competitor);
            this.competitors.add(newCompetitor);
        }
        for (int i = 0; i < NUMBER_OF_COMPETITORS; i ++) {
            this.competitors.get(i).start();
        }
        for (int i = 0; i < NUMBER_OF_COMPETITORS; i ++) {
            try {
                this.competitors.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
