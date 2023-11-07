package com.springpractice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/SpringDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
