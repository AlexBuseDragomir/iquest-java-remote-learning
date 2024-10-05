package com.iquest.java.problem3.notifier;

import com.iquest.java.problem3.context.ThreadRaceContext;
import com.iquest.java.problem3.triplet.SimpleTriplet;
import com.iquest.java.problem3.team.TeamNameEnum;

public class NotifyingThread implements Runnable {

    private int number;
    private long finishTime;
    private TeamNameEnum teamName;
    private ThreadRaceContext threadRaceContext;

    public NotifyingThread(int number, long finishTime, TeamNameEnum teamName,
                           ThreadRaceContext threadRaceContext) {
        this.number = number;
        this.finishTime = finishTime;
        this.teamName = teamName;
        this.threadRaceContext = threadRaceContext;
    }

    @Override
    public void run() {
        this.notifyContext();
    }

    private void notifyContext() {
        SimpleTriplet<Integer, Long, TeamNameEnum> data =
                new SimpleTriplet<>(this.number, this.finishTime, this.teamName);
        this.threadRaceContext.addNewResult(data);
    }
}
