package com.deesha.medicine_distribution.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabase {

        // 1. Define the connection URL, username, and password
        // Format: jdbc:mysql://[host]:[port]/[database_name]
        private static final String URL = "jdbc:mysql://localhost:3309/medicine_distribution";
        private static final String USER = "root";
        private static final String PASSWORD = "Root";

        public static void main(String[] args) {
            System.out.println("Attempting to connect to the database...");

            // 2. Establish connection using try-with-resources
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

                if (connection != null) {
                    System.out.println("Success! Connected to the MySQL database.");
                    // You can perform database operations (Queries, Inserts, etc.) here
                }

            } catch (SQLException e) {
                System.err.println("Database connection failed!");
                e.printStackTrace();
            }
        }
    }