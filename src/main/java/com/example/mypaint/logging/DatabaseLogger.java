package com.example.mypaint.logging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogger implements LoggerStrategy {
    private final String url = "jdbc:sqlite:log.db";

    public DatabaseLogger() {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "CREATE TABLE IF NOT EXISTS logs (id INTEGER PRIMARY KEY, message TEXT)";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.err.println("DB init error: " + e.getMessage());
        }
    }

    @Override
    public void log(String message) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO logs(message) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, message);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("DB log error: " + e.getMessage());
        }
    }
}
