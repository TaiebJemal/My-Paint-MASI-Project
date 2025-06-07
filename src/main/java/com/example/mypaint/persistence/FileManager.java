package com.example.mypaint.persistence;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void saveDrawing(Pane pane) {
        try (FileWriter writer = new FileWriter("drawing.txt")) {
            for (Node node : pane.getChildren()) {
                writer.write(node.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
