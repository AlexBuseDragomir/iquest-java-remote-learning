package com.iquest.java.database;

import com.iquest.java.connection.MySqlConnectionHandler;
import com.iquest.java.models.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import static com.iquest.java.database.SqlQueries.*;

public class OperationHandler {

    private Connection connection;

    private static final Logger LOGGER =
            Logger.getLogger(OperationHandler.class.getName());

    public OperationHandler(Connection connection) {
        this.connection = connection;
    }

    public void performOperation(Operation operation) {
        try {
            UserHandler userHandler = new UserHandler(this.connection);
            this.connection.setAutoCommit(false);

            // change to the operation table
            this.insertNewOperation(operation);

            // change to the user table
            int userId = operation.getUserId();
            double newAmount = operation.getAmount();
            userHandler.updateUserBalance(userId, newAmount);

            // commit changes after transaction finished
            this.connection.commit();
        } catch (SQLException e) {
            LOGGER.warning("Could not perform transaction");
            LOGGER.warning("Rolling back to last commit...");
            try {
                this.connection.rollback();
                LOGGER.info("Database has been restored to initial state");
            } catch (SQLException e1) {
                LOGGER.warning("Rollback failed");
            }
        } finally {
            try {
                this.connection.setAutoCommit(true);
            } catch (SQLException e) {
                LOGGER.warning("Could not set auto commit to true");
            }
        }
    }

    private void insertNewOperation(Operation operation)
            throws SQLException {
        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(INSERT_INTO_OPERATION);
            preparedStatement.setDouble(1, operation.getAmount());
            preparedStatement.setString(2, operation.getDescription());
            preparedStatement.setInt(3, operation.getUserId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.warning("Could not insert a new operation");
            throw new SQLException();
        }
    }
}
