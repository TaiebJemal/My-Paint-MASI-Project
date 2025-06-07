package com.example.mypaint.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements LoggerStrategy {
    private final String filename = "log.txt";

    @Override
    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println("[LOG] " + message);
        } catch (IOException e) {
            System.err.println("Failed to write log to file.");
        }
    }
}
