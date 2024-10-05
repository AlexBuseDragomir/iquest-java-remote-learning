package com.iquest.java.problem3.main;

import com.iquest.java.problem3.factory.TrainFactory;
import com.iquest.java.problem3.train.Train;
import com.iquest.java.problem3.train.TrainDepot;

import java.util.HashSet;
import java.util.Set;

public class MainLauncher {

    public static void main(String[] args) {

        TrainDepot trainDepot = new TrainDepot(new HashSet<>());
        Set<Integer> trainNumberSet = new HashSet<>();
        TrainFactory trainFactory = new TrainFactory();

        for (int i = 0; i < 100; i ++) {
            Train newTrain = trainFactory.getRandomTrain();
            trainDepot.addTrainToDepot(newTrain);
            trainNumberSet.add(newTrain.getTrainNumber());
        }

        if (trainNumberSet.size() == trainDepot.getDepot().size()) {
            System.out.println("Program works as expected");
        } else {
            System.err.println("The set is not working");
        }
        System.out.println();

        trainDepot.printTrainsFromDepot();
    }
}
