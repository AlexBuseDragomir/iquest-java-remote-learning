package com.iquest.java.problem3.race;

import com.iquest.java.problem3.context.ThreadRaceContext;
import com.iquest.java.problem3.team.TeamNameEnum;
import com.iquest.java.problem3.team.ThreadRelayRaceTeam;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRace implements Runnable {

    private final static int NUMBER_OF_TEAMS = 10;
    private final static int TEAM_SIZE = 4;
    private ThreadRaceContext threadRaceContext;
    private List<Thread> teams;

    public ThreadRelayRace(ThreadRaceContext threadRaceContext) {
        this.threadRaceContext = threadRaceContext;
        this.teams = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_TEAMS; i ++) {
            TeamNameEnum teamName = TeamNameEnum.values()[i];
            ThreadRelayRaceTeam team = new ThreadRelayRaceTeam(teamName,
                    TEAM_SIZE, this.threadRaceContext);
            teams.add(new Thread(team));
        }
        for (int i = 0; i < NUMBER_OF_TEAMS; i ++) {
            teams.get(i).start();
        }
        for (int i = 0; i < NUMBER_OF_TEAMS; i ++) {
            try {
                teams.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumberOfCompetitors() {
        return NUMBER_OF_TEAMS * TEAM_SIZE;
    }

    public int getTeamSize() {
        return TEAM_SIZE;
    }
}
