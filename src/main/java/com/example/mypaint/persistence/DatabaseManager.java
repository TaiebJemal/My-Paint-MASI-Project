package com.example.mypaint.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private final String url = "jdbc:sqlite:mypaint.db";

    public DatabaseManager() {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "CREATE TABLE IF NOT EXISTS drawings (id INTEGER PRIMARY KEY, description TEXT)";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    public void save(String description) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO drawings(description) VALUES('" + description + "')";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.err.println("Error saving to database: " + e.getMessage());
        }
    }
}
