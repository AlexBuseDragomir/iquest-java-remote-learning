package com.iquest.java.problem4.connection;

public class Connection {

    private final static int ERROR_CODE = -1;
    private boolean isConnectionActive;
    private DataBuffer globalDataBuffer;
    private int connectionId;

    Connection(int connectionId) {
        this.isConnectionActive = false;
        this.connectionId = connectionId;
    }

    public void establishConnection(DataBuffer globalDataBuffer) {
        this.globalDataBuffer = globalDataBuffer;
        this.isConnectionActive = true;
    }

    public void addDataToBuffer(int valueToAdd) {
        if (this.isConnectionActive) {
            this.globalDataBuffer.addData(valueToAdd);
        }else {
            System.err.println("Error in ConnectionObject " +
                    " : connection has not been established!");
        }
    }

    public int retrieveDataFromBuffer() {
        if (this.isConnectionActive) {
            return this.globalDataBuffer.retrieveData();
        }else {
            System.err.println("Error in ConnectionObject " +
                    " : connection has not been established!");
            return ERROR_CODE;
        }
    }

    public boolean getIsConnectionActive() {
        return this.isConnectionActive;
    }

    public void setIsConnectionActive(boolean connectionStatus) {
        this.isConnectionActive = connectionStatus;
    }
}
