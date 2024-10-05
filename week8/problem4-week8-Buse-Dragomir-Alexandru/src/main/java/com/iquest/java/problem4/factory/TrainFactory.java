package com.iquest.java.problem4.factory;

import com.iquest.java.problem4.train.Train;
import com.iquest.java.problem4.type.TrainType;

import java.util.*;

public class TrainFactory {

    private final static int MAX_NUMBER_OF_WAGONS = 100;
    private static final int MAX_TRAIN_NUMBER = 10000;
    private static final int MAX_NUMBER_OF_TRAVELING_DAYS = 30;
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

    public List<Integer> getRandomListOfTravelingDays() {
        Random random = new Random();
        int numberOfDays = random.nextInt(MAX_NUMBER_OF_TRAVELING_DAYS) + 1;
        Set<Integer> travelDays = new HashSet<>();
        for (int i = 0; i < numberOfDays; i ++) {
            int randomDay = random.nextInt(365) + 1;
            travelDays.add(randomDay);
        }
        return new ArrayList<>(travelDays);
    }
}
