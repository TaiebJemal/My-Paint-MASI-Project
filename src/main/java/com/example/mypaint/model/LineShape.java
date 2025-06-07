package com.example.mypaint.model;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape implements Shape {
    @Override
    public Node draw() {
        Line line = new Line(50, 50, 150, 150);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        return line;
    }
}
