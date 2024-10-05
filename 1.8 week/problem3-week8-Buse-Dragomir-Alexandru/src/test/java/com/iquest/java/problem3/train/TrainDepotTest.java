package com.iquest.java.problem3.train;

import com.iquest.java.problem3.type.TrainType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrainDepotTest {

    private TrainDepot trainDepot;

    @Before
    public void setUp() {
        this.trainDepot = new TrainDepot(new HashSet<>());

        List<Train> listOfTrains = new ArrayList<>();
        listOfTrains.add(new Train(1, TrainType.LONG_DISTANCE_RAIL, 15));
        listOfTrains.add(new Train(2, TrainType.HIGH_SPEED_RAIL, 6));
        listOfTrains.add(new Train(3, TrainType.INTER_CITY, 6));
        listOfTrains.add(new Train(4, TrainType.REGIONAL, 10));
        listOfTrains.add(new Train(5, TrainType.LIGHT_RAIL, 10));

        // adding each train ten times
        for (int i = 0; i < 10; i ++) {
            for (Train train: listOfTrains) {
                this.trainDepot.addTrainToDepot(train);
            }
        }
    }

    @Test
    public void testAddingTrainsToDepot() {
        // WHEN
        boolean isLongDistanceRailPresent = this.trainDepot.isTrainInDepot(1);
        boolean isHighSpeedRailPresent = this.trainDepot.isTrainInDepot(2);
        boolean isInterCityRailPresent = this.trainDepot.isTrainInDepot(3);
        boolean isRapidTransitRailPresent = this.trainDepot.isTrainInDepot(4);
        // it is rapid rail and has 10 wagons, but another identification number
        // so it must be added, because it is in fact another train
        boolean isSecondRapidTransitRailPresent = this.trainDepot.isTrainInDepot(5);

        // THEN
        assertThat(this.trainDepot.getNumberOfTrainsInDepot(), is(5));
        assertThat(isLongDistanceRailPresent, is(true));
        assertThat(isHighSpeedRailPresent, is(true));
        assertThat(isInterCityRailPresent, is(true));
        assertThat(isRapidTransitRailPresent, is(true));
        assertThat(isSecondRapidTransitRailPresent, is(true));
    }
}