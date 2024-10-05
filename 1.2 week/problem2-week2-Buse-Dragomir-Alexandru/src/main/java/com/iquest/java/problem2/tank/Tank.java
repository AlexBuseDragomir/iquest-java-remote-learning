package com.iquest.java.problem2.tank;

import java.util.LinkedList;
import java.util.List;

public class Tank {

    private List<Object> stack;
    private int tankCapacity;

    public Tank(int tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.stack = new LinkedList<>();
    }

    public void pushValueIntoTank(int newValue) {
        if (this.stack.size() < tankCapacity) {
            this.stack.add(newValue);
        }else {
            System.err.println("ERROR: Can't perform a push -> the tank is full!");
        }
    }

    public Object popValueFromTank() {
        if (this.stack.size() > 0) {
            return this.stack.remove(this.getTankSize() - 1);
        }else {
            System.out.println("ERROR: Can't perform a pop -> the tank is empty");
            return null;
        }
    }

    public int getTankSize() {
        return this.stack.size();
    }

    @Override
    protected void finalize() {
        if (this.isTankEmpty()) {
            System.out.println("NOTIFICATION: The tank was empty and has been successfully deleted!");
        }else {
            this.emptyTank();
            System.err.println("ERROR: The tank is not empty and all data will be erased in order to delete it!");
            System.err.println(">>>>> Tank has been emptied and deleted!");
        }
    }

    private void emptyTank() {
        this.stack.clear();
    }

    private boolean isTankEmpty() {
        return this.stack.size() == 0;
    }

}
