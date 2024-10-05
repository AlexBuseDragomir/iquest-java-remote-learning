package com.iquest.java.database;

import com.iquest.java.connection.MySqlConnectionHandler;
import com.iquest.java.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static com.iquest.java.database.SqlQueries.*;

public class UserHandler {

    private Connection connection;

    private static final Logger LOGGER =
            Logger.getLogger(UserHandler.class.getName());

    public UserHandler(Connection connection) {
        this.connection = connection;
    }

    public ResultSet listAllUsers() {
        ResultSet users = this.getAllUsers();

        try {
            while (users.next()) {
                System.out.println(users.getString("name") + "  " +
                        users.getString("username") + "  " +
                        users.getDouble("balance"));
            }
        } catch (SQLException e) {
            LOGGER.warning("Failed while trying to list all users");
        }

        return users;
    }

    public double getBalanceOfUserByUsername(String username) {
        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SELECT_BALANCE_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            LOGGER.warning("Failed to retrieve balance of user " + username);
        }

        throw new NoSuchElementException("There is no user with that username");
    }

    public List<User> getUsersWithBalanceOverValue(double balanceLowerLimit) {
        List<User> resultList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SELECT_FROM_USERS_BY_BALANCE);
            preparedStatement.setDouble(1, balanceLowerLimit);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setBalance(resultSet.getDouble("balance"));

                resultList.add(user);
            }
        } catch (SQLException e) {
            LOGGER.warning("Failed to extract users with balance over " +
                    balanceLowerLimit);
        }
        return resultList;
    }

    public void updateUserBalance(int userId, double newAmount)
            throws SQLException {
        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(UPDATE_USER_BALANCE);
            preparedStatement.setDouble(1, newAmount);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warning("Failed to update user balance");
            throw new SQLException();
        }
    }

    private ResultSet getAllUsers() {
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SELECT_ALL_FROM_USER);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            LOGGER.warning("Failed to extract all users from Db");
        }
        return resultSet;
    }
}
