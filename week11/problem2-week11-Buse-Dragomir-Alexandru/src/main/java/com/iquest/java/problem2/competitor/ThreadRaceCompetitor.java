package com.iquest.java.problem2.competitor;

import com.iquest.java.problem2.context.ThreadRaceContext;
import com.iquest.java.problem2.pair.SimplePair;

import java.util.Random;

public class ThreadRaceCompetitor implements Runnable {

    private int number;
    private long finishTime;
    private ThreadRaceContext threadRaceContext;

    public ThreadRaceCompetitor(int number, ThreadRaceContext threadRaceContext) {
        this.number = number;
        this.threadRaceContext = threadRaceContext;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.finishTime = System.currentTimeMillis();
        this.notifyContextAfterFinish();
    }

    private void notifyContextAfterFinish() {
        this.threadRaceContext.addNewResult(new SimplePair<>(this.number, this.finishTime));
    }
}
