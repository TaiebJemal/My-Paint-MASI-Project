package com.example.mypaint.model;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleShape implements Shape {
    @Override
    public Node draw() {
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.LIGHTGREEN);
        circle.setStroke(Color.BLACK);
        return circle;
    }
}
