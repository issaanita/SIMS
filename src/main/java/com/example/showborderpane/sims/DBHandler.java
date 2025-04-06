package com.example.showborderpane.sims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Class;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost/stims?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successdully");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load driver: " + e.getMessage());
            throw new RuntimeException("Database driver not found");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int executeUpdate(String sql, Object... params) {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            setParameters(statement, params);
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return -1;
        }
    }

    private static void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    public static int executeQueryForInt(String query, String param) {
        int result = 0;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, param);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet executeQuery(String sql, Object... params) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            setParameters(statement, params);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public static int getCountFromDatabase(String query) {
        int count = 0;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error executing count query: " + e.getMessage());
        }
        return count;
    }
}