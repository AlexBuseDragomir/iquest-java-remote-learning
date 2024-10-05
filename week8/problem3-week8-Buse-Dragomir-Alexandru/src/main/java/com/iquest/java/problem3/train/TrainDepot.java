package com.iquest.java.problem3.train;

import java.util.Set;

public class TrainDepot {

    private Set<Train> depot;

    public TrainDepot(Set<Train> depot) {
        this.depot = depot;
    }

    public void addTrainToDepot(Train newTrain) {
        this.depot.add(newTrain);
    }

    public boolean isTrainInDepot(int trainNumber) {
        for (Train train: depot) {
            if (train.getTrainNumber() == trainNumber) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfTrainsInDepot() {
        return this.depot.size();
    }

    public void printTrainsFromDepot() {
        for (Train train: this.depot) {
            System.out.println(train);
        }
    }

    public Set<Train> getDepot() {
        return this.depot;
    }
}
