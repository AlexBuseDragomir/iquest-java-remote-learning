package com.iquest.java.problem4.main;

import com.iquest.java.problem4.connection.ConnectionManager;
import com.iquest.java.problem4.connection.DataBuffer;
import com.iquest.java.problem4.connection.Connection;

public class MainLauncher{

    public static void main(String[] args) {

        DataBuffer dataBuffer = new DataBuffer();
        ConnectionManager connectionManager = new ConnectionManager();

        Connection connection1 = connectionManager.getConnection();
        connection1.establishConnection(dataBuffer);

        for(int index = 0; index < 10; index ++){
            connection1.addDataToBuffer(index * index);
        }

        for(int index = 0; index < 10; index ++){
            System.out.println("Value from Buffer trough a connection: " +
                    connection1.retrieveDataFromBuffer());
        }
    }
}
