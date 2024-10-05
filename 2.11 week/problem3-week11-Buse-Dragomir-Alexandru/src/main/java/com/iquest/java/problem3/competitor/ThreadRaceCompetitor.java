package com.iquest.java.problem3.competitor;

import com.iquest.java.problem3.context.ThreadRaceContext;
import com.iquest.java.problem3.team.TeamNameEnum;
import com.iquest.java.problem3.notifier.NotifyingThread;

import java.util.Random;

public class ThreadRaceCompetitor implements Runnable {

    private int number;
    private ThreadRaceContext threadRaceContext;
    private TeamNameEnum teamName;

    public ThreadRaceCompetitor(int number, TeamNameEnum teamName, ThreadRaceContext threadRaceContext) {
        this.number = number;
        this.teamName = teamName;
        this.threadRaceContext = threadRaceContext;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis();

        // letting the notifying job for another thread because it takes time
        // and we want to start the next team member as fast as possible
        NotifyingThread notifier = new NotifyingThread(this.number, finishTime,
                this.teamName, this.threadRaceContext);
        Thread notifierThread = new Thread(notifier);
        notifierThread.start();
        // we wait for the notifier to end before terminating the competitor thread
        try {
            notifierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
