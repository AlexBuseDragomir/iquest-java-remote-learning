package com.iquest.java.problem2.main;

import com.iquest.java.problem2.tank.Tank;

public class MainLauncher {

    private final static int TANK_CAPACITY = 5;

    public static void main(String[] args) {
        Tank tank = new Tank(TANK_CAPACITY);

        for (int index = 0; index < TANK_CAPACITY; index ++) {
            tank.pushValueIntoTank(index);
            System.out.println("The value " + index + " has been added at the top of the tank");
        }

        int tankSize = tank.getTankSize();
        System.out.println();

        for (int index = 0; index < tankSize; index ++) {
            System.out.println("The value " + tank.popValueFromTank() + " has been removed from " +
                               "the top of the tank");
        }

        System.out.println();
        int newValue = 5;
        tank.pushValueIntoTank(newValue);
        System.out.println("The value " + newValue + " has been added at the top of the tank");

        System.out.println();
        System.out.println("STARTING THE DELETION PROCESS...");
        tank = null;
        System.gc();
    }
}
