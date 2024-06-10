package com.bibloteca.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "12345678903";
    private static Connection jdbcConnection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            jdbcConnection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        }
        return jdbcConnection;
    }

    public static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}

