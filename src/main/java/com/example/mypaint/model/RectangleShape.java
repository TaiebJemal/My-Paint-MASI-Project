package com.example.mypaint.model;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape implements Shape {
    @Override
    public Node draw() {
        Rectangle rect = new Rectangle(50, 50, 100, 70);
        rect.setFill(Color.LIGHTBLUE);
        rect.setStroke(Color.BLACK);
        return rect;
    }
}
