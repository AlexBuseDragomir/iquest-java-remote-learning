package com.iquest.java.database;

import com.iquest.java.connection.ConnectionHandler;
import com.iquest.java.connection.MySqlConnectionHandler;
import com.iquest.java.models.Operation;
import com.iquest.java.models.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.iquest.java.database.SqlQueries.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DatabaseHandlersTest {

    private UserHandler userHandler;
    private OperationHandler operationHandler;

    private Connection connection;
    private List<String> username;

    private static final String DB_CONFIGURATION_FILE_NAME =
            "MySqlConfiguration.txt";

    private static final Logger LOGGER =
            Logger.getLogger(DatabaseHandlersTest.class.getName());

    // table contents after maven install (auto-running of sql script)
    /*             USERS
      (1, "Monica Albert", "monica", 999.99);
      (2, "Andrew Jackson", "andrew", 250.30);
      (3, "John Petterson", "john", 3450.65);
      (4, "Michelle Stone", "michelle", 1678.20);
      (5, "Irwin Stevens", "irwin", 4200.99);
      (6, "Anne Watches", "anne", 8900.10);

                 OPERATIONS
      (3000, "salary for April", 1);
      (-260, "new carpet", 1);
      (3600, "salary for May", 2);
      (850, "gratuity for holidays", 3);
      (-500, "police ticket", 4);
      (-19.99, "twitch subscription", 4);
      (-2500, "donation for charity", 5);
      (1700, "private scholarship", 6);*/

    @Before
    public void setUp() {
        ConnectionHandler connectionHandler =
                new MySqlConnectionHandler(DB_CONFIGURATION_FILE_NAME);

        this.connection = connectionHandler.getConnection();

        this.userHandler = new UserHandler(this.connection);
        this.operationHandler = new OperationHandler(this.connection);

        this.username = new ArrayList<>();
        this.username.add("monica");
        this.username.add("andrew");
        this.username.add("john");
        this.username.add("michelle");
        this.username.add("irwin");
        this.username.add("anne");
    }

    @Test
    public void testGetAllUsers() {
        ResultSet resultSet = this.userHandler.listAllUsers();
        int i = 0;

        try {
            while (resultSet.next()) {
                assertThat(resultSet.getString("username"),
                        is(this.username.get(i)));
            }
        } catch (SQLException e) {
            LOGGER.warning("Could not iterate over the result set");
        }
    }

    @Test
    public void testGetBalanceOfUserByUsername() {
        Double balance = this.userHandler.getBalanceOfUserByUsername("andrew");
        assertThat(balance, is(250.30));
    }

    @Test
    public void testGetUsersWithBalanceOverValue() {
        List<User> list4000 = this.userHandler.getUsersWithBalanceOverValue(4000);
        List<User> list5000 = this.userHandler.getUsersWithBalanceOverValue(5000);

        for (User user: list4000) {
            assert(user.getBalance() >= 4000);
        }
        for (User user: list5000) {
            assert(user.getBalance() >= 5000);
        }
        assertThat(list4000.size(), is(2));
        assertThat(list5000.size(), is(1));
    }

    @Test
    public void testPerformOperation() {
        // we extract 50.60 from user with id 1 (monica)
        double balanceBefore = this.userHandler.getBalanceOfUserByUsername("monica");

        Operation operation = new Operation(-50.60, "new shoes", 1);
        this.operationHandler.performOperation(operation);

        double balanceAfter = this.userHandler.getBalanceOfUserByUsername("monica");

        // check to see if User table is updated
        assert(Math.abs(balanceAfter - (balanceBefore - 50.60)) <= 0.1);

        // check if there is a new operation
        ResultSet resultSet = null;

        try {
            resultSet = this.getAllOperations();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertNotNull(resultSet);

        try {
            double amount = -1;
            String description = null;
            int userId = -1;

            while (resultSet.next()) {
                amount = resultSet.getDouble("amount");
                description = resultSet.getString("description");
                userId = resultSet.getInt("user_id");
            }

            // check if last operation is the one we inserted
            assertThat(amount, is(-50.60));
            assertThat(description, is("new shoes"));
            assertThat(userId, is(1));
        } catch (SQLException e) {
            LOGGER.warning("Could not iterate over the result set");
        }
    }

    private ResultSet getAllOperations()
            throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SELECT_ALL_FROM_OPERATION);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warning("Failed to retrieve balance of user " + username);
            throw new SQLException();
        }
        return resultSet;
    }
}










