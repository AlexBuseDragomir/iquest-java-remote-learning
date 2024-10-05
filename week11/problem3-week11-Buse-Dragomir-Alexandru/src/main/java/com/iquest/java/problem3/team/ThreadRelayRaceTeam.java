package com.iquest.java.problem3.team;

import com.iquest.java.problem3.competitor.ThreadRaceCompetitor;
import com.iquest.java.problem3.context.ThreadRaceContext;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRaceTeam implements Runnable {

    private int teamSize;
    private TeamNameEnum teamName;
    private ThreadRaceContext threadRaceContext;
    private List<Thread> teamMembers;

    public ThreadRelayRaceTeam(TeamNameEnum teamName, int teamSize, ThreadRaceContext threadRaceContext) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        this.threadRaceContext = threadRaceContext;
        this.teamMembers = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < teamSize; i ++) {
            ThreadRaceCompetitor competitor =
                    new ThreadRaceCompetitor(i + 1, this.teamName, this.threadRaceContext);
            this.teamMembers.add(new Thread(competitor));
        }
        for (int i = 0; i < teamSize; i ++) {
            this.teamMembers.get(i).start();
            try {
                this.teamMembers.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
