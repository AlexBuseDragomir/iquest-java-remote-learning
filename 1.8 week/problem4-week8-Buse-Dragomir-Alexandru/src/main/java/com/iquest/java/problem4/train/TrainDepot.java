package com.iquest.java.problem4.train;

import java.util.List;
import java.util.Map;

public class TrainDepot {

    private Map<Train, List<Integer>> depot;

    public TrainDepot(Map<Train, List<Integer>> depot) {
        this.depot = depot;
    }

    public void addTrainToDepot(Train newTrain, List<Integer> travelDays) {
        this.depot.put(newTrain, travelDays);
    }

    public void printTrainsFromDepot() {
        for (Train train: this.depot.keySet()) {
            List<Integer> travelDays = this.depot.get(train);
            System.out.print(train);
            System.out.print(" " + travelDays);
            System.out.println();
        }
    }

    public Map<Train, List<Integer>> getDepot() {
        return this.depot;
    }
}
