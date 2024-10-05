package com.iquest.java.database;

import com.iquest.java.connection.MySqlConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.iquest.java.database.SqlQueries.*;

public class MetadataHandler {

    private Connection connection;

    private static final int TABLE_NAME = 3;
    private static final Logger LOGGER =
            Logger.getLogger(MetadataHandler.class.getName());

    public MetadataHandler(Connection connection) {
        this.connection = connection;
    }

    public void listDatabaseMetadata() {
        try {
            DatabaseMetaData databaseMetaData = this.connection.getMetaData();

            // getting database name
            String databaseName = this.getCurrentDatabaseName(this.connection);
            System.out.println("Database name: " + databaseName);

            // getting table names
            List<String> tableNames = this.getTableNames(databaseMetaData, databaseName);
            System.out.println();

            // iterate over each table and get column names
            for (String table: tableNames) {
                System.out.println("TABLE: " + table);
                ResultSet columnResult = databaseMetaData.getColumns(databaseName, null,
                        table, null);
                System.out.print("Columns: ");
                while (columnResult.next()) {
                    System.out.print(columnResult.getString("COLUMN_NAME") + " | ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            LOGGER.warning("Could not perform SQL operations in function" +
                    "listDatabaseMetadata()");
        }
    }

    private List<String> getTableNames(DatabaseMetaData databaseMetaData, String databaseName) {
        List<String> tableNames = new ArrayList<>();
        try {
            ResultSet tableResult = databaseMetaData.getTables(databaseName, null,
                    "%", null);
            while (tableResult.next()) {
                tableNames.add(tableResult.getString(TABLE_NAME));
            }
        } catch (SQLException e) {
            LOGGER.warning("Failed while extracting table names");
        }
        return tableNames;
    }

    private String getCurrentDatabaseName(Connection connection) {
        String databaseName = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATABASE);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                databaseName = result.getString("DATABASE()");
                return databaseName;
            }
        } catch (SQLException e) {
            LOGGER.warning("Failed while extracting the database name");
        }
        return databaseName;
    }
}
