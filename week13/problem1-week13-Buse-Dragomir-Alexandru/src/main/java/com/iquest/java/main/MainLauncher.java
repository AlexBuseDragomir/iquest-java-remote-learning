package com.iquest.java.main;

import com.iquest.java.connection.ConnectionHandler;
import com.iquest.java.connection.MySqlConnectionHandler;
import com.iquest.java.database.MetadataHandler;
import com.iquest.java.database.OperationHandler;
import com.iquest.java.database.UserHandler;
import com.iquest.java.models.Operation;
import com.iquest.java.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class MainLauncher {

    private static final String DB_CONFIGURATION_FILE_NAME =
            "MySqlConfiguration.txt";

    public static void main(String[] args) {

        ConnectionHandler connectionHandler =
                new MySqlConnectionHandler(DB_CONFIGURATION_FILE_NAME);

        Connection connection = connectionHandler.getConnection();

        UserHandler userHandler = new UserHandler(connection);
        OperationHandler operationHandler = new OperationHandler(connection);
        MetadataHandler metadataHandler = new MetadataHandler(connection);

        System.out.println("All users:");
        ResultSet resultSet = userHandler.listAllUsers();

        System.out.println();
        System.out.println("Balance of Monica: ");
        System.out.println(userHandler.getBalanceOfUserByUsername("monica"));

        List<User> balanceOver1000List = userHandler.getUsersWithBalanceOverValue(1000);
        System.out.println();
        System.out.println("Balance over 1000: ");
        for (User user: balanceOver1000List) {
            System.out.println(user.getName() + "   " + user.getBalance());
        }

        Operation operation = new Operation(-50.60, "new shoes", 1);
        operationHandler.performOperation(operation);

        System.out.println();
        System.out.println("Balance of Monica after buying new shoes: ");
        System.out.println(userHandler.getBalanceOfUserByUsername("monica"));

        System.out.println();
        metadataHandler.listDatabaseMetadata();
    }
}
