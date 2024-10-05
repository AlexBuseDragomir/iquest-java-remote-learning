package com.iquest.java.database;

public final class SqlQueries {

    // TABLES
    private static final String OPERATION_TABLE = "operation";
    private static final String USER_TABLE = "user";

    // METADATA
    public static final String SELECT_DATABASE = "SELECT DATABASE()";

    // OPERATION
    public  static final String SELECT_ALL_FROM_OPERATION =
            "SELECT * FROM " + OPERATION_TABLE;

    public static final String INSERT_INTO_OPERATION =
            "INSERT INTO " + OPERATION_TABLE + "(amount, description, user_id) VALUES(?, ?, ?)";

    // USER
    public static final String SELECT_ALL_FROM_USER = "SELECT * FROM " + USER_TABLE;

    public static final String UPDATE_USER_BALANCE = "UPDATE " + USER_TABLE +
            " SET balance = balance + ?  WHERE id = ?";

    public static final String SELECT_FROM_USERS_BY_BALANCE =
            "SELECT * FROM " + USER_TABLE + " WHERE balance >= ?";

    public static final String SELECT_BALANCE_BY_USERNAME =
            "SELECT balance FROM " + USER_TABLE + " WHERE username = ?";
}
