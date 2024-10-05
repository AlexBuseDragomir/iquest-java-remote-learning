package com.iquest.java.problem4.main;

import com.iquest.java.problem4.factory.TrainFactory;
import com.iquest.java.problem4.train.Train;
import com.iquest.java.problem4.train.TrainDepot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        TrainDepot trainDepot = new TrainDepot(new HashMap<>());
        List<Train> trainList = new ArrayList<>();
        List<List<Integer>> listOfTravelingDays = new ArrayList<>();
        TrainFactory trainFactory = new TrainFactory();

        for (int i = 0; i < 10000; i ++) {
            Train newTrain = trainFactory.getRandomTrain();
            List<Integer> travelingDays = trainFactory.getRandomListOfTravelingDays();
            trainDepot.addTrainToDepot(newTrain, travelingDays);
            trainList.add(newTrain);
        }

        long startTime = System.nanoTime() / 1000;

            for (int i = 0; i < 10000; i ++) {
                listOfTravelingDays.add(trainDepot.getDepot().get(trainList.get(i)));
            }

        long stopTime = System.nanoTime() / 1000;
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " microseconds");

        // different hash code -> ~ 0-10 milliseconds, average of 5 milliseconds (~ 0.005 seconds)
        // same hash code implies the usage of equals -> ~900-1000 milliseconds (~ 1 second)

        //System.out.println();
        //trainDepot.printTrainsFromDepot();
    }
}
