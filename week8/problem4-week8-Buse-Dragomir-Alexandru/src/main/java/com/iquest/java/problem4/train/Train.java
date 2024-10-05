package com.iquest.java.problem4.train;

import com.iquest.java.problem4.type.TrainType;

public class Train {

    private int trainNumber;
    private TrainType trainType;
    private int numberOfWagons;

    public Train(int trainNumber, TrainType trainType, int numberOfWagons) {
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.numberOfWagons = numberOfWagons;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Train train = (Train) obj;

        if (this.hashCode() != train.hashCode()) {
            return false;
        } else {
            return this.trainNumber == train.trainNumber;
        }
    }

    @Override
    public int hashCode() {
        return this.trainNumber;
    }

    @Override
    public String toString() {
        return "Train(" + this.trainNumber + ")" + " - " + this.trainType +
                " has " + this.numberOfWagons + " wagons";
    }
}
