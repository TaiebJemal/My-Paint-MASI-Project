package com.example.mypaint.controller;

import com.example.mypaint.factory.ShapeFactory;
import com.example.mypaint.model.Shape;
import com.example.mypaint.view.DrawingView;
import javafx.scene.Node;

public class DrawingController {
    private final DrawingView view;

    public DrawingController(DrawingView view) {
        this.view = view;
        initialize();
    }

    private void initialize() {
        view.getRectangleButton().setOnAction(e -> drawShape("rectangle"));
        view.getCircleButton().setOnAction(e -> drawShape("circle"));
        view.getLineButton().setOnAction(e -> drawShape("line"));
    }

    private void drawShape(String type) {
        Shape shape = ShapeFactory.createShape(type);
        Node node = shape.draw();
        view.getDrawingPane().getChildren().add(node);
    }
}
