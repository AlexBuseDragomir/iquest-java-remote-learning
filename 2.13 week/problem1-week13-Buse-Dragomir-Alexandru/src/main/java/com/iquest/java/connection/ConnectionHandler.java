package com.iquest.java.connection;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionHandler {

    Connection getConnection();
}
