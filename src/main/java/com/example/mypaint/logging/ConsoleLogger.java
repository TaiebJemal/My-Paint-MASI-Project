package com.example.mypaint.logging;

public class ConsoleLogger implements LoggerStrategy {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
