package com.iquest.java.problem3.factory;

import com.iquest.java.problem3.train.Train;
import com.iquest.java.problem3.type.TrainType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrainFactory {

    private final static int MAX_NUMBER_OF_WAGONS = 100;
    private static final int MAX_TRAIN_NUMBER = 10000;
    private static List<TrainType> typesOfTrains = new ArrayList<>();

    static {
        typesOfTrains.add(TrainType.LONG_DISTANCE_RAIL);
        typesOfTrains.add(TrainType.HIGH_SPEED_RAIL);
        typesOfTrains.add(TrainType.INTER_CITY);
        typesOfTrains.add(TrainType.RAPID_TRANSIT);
        typesOfTrains.add(TrainType.REGIONAL);
        typesOfTrains.add(TrainType.LIGHT_RAIL);
    }

    public Train getRandomTrain() {
        Random random = new Random();
        TrainType trainType = typesOfTrains.get(random.nextInt(6));
        int numberOfWagons = random.nextInt(MAX_NUMBER_OF_WAGONS) + 1;
        int trainNumber = random.nextInt(MAX_TRAIN_NUMBER) + 1;
        return new Train(trainNumber, trainType, numberOfWagons);
    }
}
