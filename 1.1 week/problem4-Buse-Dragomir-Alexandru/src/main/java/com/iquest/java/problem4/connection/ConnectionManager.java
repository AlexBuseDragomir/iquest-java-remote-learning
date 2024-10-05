package com.iquest.java.problem4.connection;

import java.util.ArrayList;

public class ConnectionManager {

    private final static int MAX_CONNECTION_NUMBER = 4;
    private ArrayList<Connection> connectionList;
    private int numberOfActiveConnections;

    public ConnectionManager() {
        this.connectionList = new ArrayList<Connection>(MAX_CONNECTION_NUMBER);
        this.numberOfActiveConnections = 0;

        for (int index = 0; index < MAX_CONNECTION_NUMBER; index++) {
            Connection newConnection = new Connection(index);
            this.connectionList.add(newConnection);
        }
    }

    public Connection getConnection() {
        if (this.numberOfActiveConnections < 4) {
            for (int index = 0; index < MAX_CONNECTION_NUMBER; index++) {
                if (!connectionList.get(index).getIsConnectionActive()) {
                    connectionList.get(index).setIsConnectionActive(true);
                    this.numberOfActiveConnections++;

                    return connectionList.get(index);
                }
            }
        }
        return null;
    }

    public Connection getConnectionWithId(int connectionId) {
        if (! this.connectionList.get(connectionId).getIsConnectionActive()) {
            connectionList.get(connectionId).setIsConnectionActive(true);
            this.numberOfActiveConnections ++;
            return this.connectionList.get(connectionId);
        }
        return null;
    }

    public void releaseConnectionWithId(int connectionId) {
        this.connectionList.get(connectionId).setIsConnectionActive(false);
        this.numberOfActiveConnections --;
    }
}
