package com.iquest.java.connection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class MySqlConnectionHandler implements ConnectionHandler {

    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    private static final String CONNECTION_STRING =
            "jdbc:mysql://%s:%s/%s?autoReconnect=true&useSSL=false";

    private static final Logger LOGGER =
            Logger.getLogger(MySqlConnectionHandler.class.getName());

    public MySqlConnectionHandler(String configFileName) {
        this.extractConfigsFromFile(configFileName);
    }

    @Override
    public Connection getConnection() {
        String connectionString = String.format(CONNECTION_STRING,
                this.dbHost, this.dbPort, this.dbName);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, this.dbUser, this.dbPassword);
        } catch (SQLException e) {
            LOGGER.warning("Could not establish connection by using: " +
                    connectionString);
        }
        return connection;
    }

    private void extractConfigsFromFile(String configFileName) {
        File configFile = this.getFileWithNameFromResources(configFileName);
        String configFilePath = configFile.getAbsolutePath();
        Path pathToFile = Paths.get(configFilePath);

        try {
            List<String> fileContent = Files.readAllLines(pathToFile);

            for (String line: fileContent) {
                String[] array = line.split("=");
                String configName = array[0].trim();
                String configValue = array[1].trim();

                switch (configName) {
                    case "DB_HOST":
                        this.dbHost = configValue;
                        break;
                    case "DB_PORT":
                        this.dbPort = configValue;
                        break;
                    case "DB_NAME":
                        this.dbName = configValue;
                        break;
                    case "DB_USER":
                        this.dbUser = configValue;
                        break;
                    case "DB_PASSWORD":
                        this.dbPassword = configValue;
                        break;
                    default:
                        LOGGER.warning("Config name " +
                                configName + " is not recognized");
                }
            }
        } catch (IOException e) {
            LOGGER.warning("Could not read file content from " + configFilePath);
        }
    }

    private File getFileWithNameFromResources(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
