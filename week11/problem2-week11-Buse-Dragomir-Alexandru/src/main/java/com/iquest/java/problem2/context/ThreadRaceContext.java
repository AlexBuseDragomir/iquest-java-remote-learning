package com.iquest.java.problem2.context;

import com.iquest.java.problem2.pair.SimplePair;
import com.iquest.java.problem2.race.ThreadRace;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadRaceContext implements Runnable {

    private ThreadRace threadRace;
    private Queue<SimplePair<Integer, Long>> results;

    public ThreadRaceContext() {
        this.threadRace = new ThreadRace(this);
        int numberOfCompetitors = this.threadRace.getNumberOfCompetitors();
        this.results = new ArrayBlockingQueue<>(numberOfCompetitors, true);
    }

    public void addNewResult(SimplePair<Integer, Long> result) {
        this.results.add(result);
    }

    @Override
    public void run() {
        Thread race = new Thread(this.threadRace);
        race.start();
        try {
            race.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.displayResult();
    }

    private void displayResult() {
        int numberOfCompetitors = this.results.size();
        for (int i = 0; i < numberOfCompetitors; i ++) {
            SimplePair<Integer, Long> currentResult = this.results.remove();
            System.out.println("[" + (i + 1) + "] -> Racer " + currentResult.getFirst() +
                    " with a time of " + currentResult.getSecond());
        }
    }
}
