package com.example.attendance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database credentials and URL (replace with your actual details)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/attendance_system?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root"; // Your MySQL username
    private static final String JDBC_PASSWORD = "rootPass"; // Your MySQL root password

    // Static block to load the JDBC driver
    static {
        try {
            // Register JDBC driver (for modern JDBC, this is often implicit but good
            // practice)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver", e);
        }
    }

    /**
     * Establishes a connection to the database.
     * 
     * @return A Connection object if successful, null otherwise.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    /**
     * Closes the given database connection.
     * 
     * @param connection The Connection object to close.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // You might also add methods to close PreparedStatement and ResultSet if you
    // create them here
    // But typically they are closed within the DAO methods themselves.
}