package com.iquest.java.problem4.connection;

import java.util.LinkedList;

public class DataBuffer {

    private final static int MAX_BUFFER_SIZE = 100;
    private final static int ERROR_CODE = -1;
    private LinkedList<Integer> sharedData;

    public DataBuffer() {
        this.sharedData = new LinkedList<>();
    }

    public void addData(int newDataValue) {
        if (this.sharedData.size() < MAX_BUFFER_SIZE) {
            this.sharedData.addLast(newDataValue);
        }else {
            System.err.println("ERROR: The buffer is full!");;
        }
    }

    public int retrieveData() {
        if(this.sharedData.size() > 0) {
            return this.sharedData.removeFirst();
        }else {
            System.err.println("ERROR: The buffer is empty!");
            return ERROR_CODE;
        }
    }
}
