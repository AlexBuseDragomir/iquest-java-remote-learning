package com.iquest.java.problem3.context;

import com.iquest.java.problem3.triplet.SimpleTriplet;
import com.iquest.java.problem3.race.ThreadRelayRace;
import com.iquest.java.problem3.team.TeamNameEnum;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadRaceContext implements Runnable {

    private ThreadRelayRace threadRelayRace;
    private Queue<SimpleTriplet<Integer, Long, TeamNameEnum>> results;

    public ThreadRaceContext() {
        this.threadRelayRace = new ThreadRelayRace(this);
        int numberOfCompetitors = this.threadRelayRace.getNumberOfCompetitors();
        this.results = new ArrayBlockingQueue<>(numberOfCompetitors, true);
    }

    public void addNewResult(SimpleTriplet<Integer, Long, TeamNameEnum> result) {
        this.results.add(result);
    }

    @Override
    public void run() {
        Thread race = new Thread(this.threadRelayRace);
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
            SimpleTriplet<Integer, Long, TeamNameEnum> currentResult = this.results.remove();
            System.out.println("[" + (i + 1) + "] -> Racer " + currentResult.getFirst() + " from " +
                    currentResult.getThird() + " with a time of " + currentResult.getSecond());

            if (currentResult.getFirst() == this.threadRelayRace.getTeamSize()) {
                System.out.println("Team " + currentResult.getThird() + " has finished!");
            }
        }
    }
}
