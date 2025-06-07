package com.example.mypaint.controller;

import com.example.mypaint.factory.ShapeFactory;
import com.example.mypaint.logging.ConsoleLogger;
import com.example.mypaint.logging.LoggerStrategy;
import com.example.mypaint.model.Shape;
import com.example.mypaint.view.DrawingView;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class DrawingController {
    private final DrawingView view;
    private String selectedShape = "rectangle";
    private final LoggerStrategy logger;
    private double startX, startY;

    public DrawingController(DrawingView view) {
        this.view = view;
        this.logger = new ConsoleLogger();
        initialize();
    }

    private void initialize() {
        view.getRectangleButton().setOnAction(e -> {
            selectedShape = "rectangle";
            log("Shape selected: Rectangle");
        });
        view.getCircleButton().setOnAction(e -> {
            selectedShape = "circle";
            log("Shape selected: Circle");
        });
        view.getLineButton().setOnAction(e -> {
            selectedShape = "line";
            log("Shape selected: Line");
        });

        view.getDrawingPane().setOnMousePressed(this::handleMousePressed);
        view.getDrawingPane().setOnMouseReleased(this::handleMouseReleased);

        view.getToggleLogButton().setOnAction(e -> {
            boolean visible = view.getLogArea().isVisible();
            view.getLogArea().setVisible(!visible);
            view.getLogArea().setManaged(!visible);
        });
    }

    private void handleMousePressed(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
    }

    private void handleMouseReleased(MouseEvent event) {
        double endX = event.getX();
        double endY = event.getY();
        double width = Math.abs(endX - startX);
        double height = Math.abs(endY - startY);
        double centerX = (startX + endX) / 2;
        double centerY = (startY + endY) / 2;

        Shape shape = ShapeFactory.createShape(selectedShape);
        Node node = shape.draw();

        Color fill = view.getSelectedFillColor();
        Color stroke = view.getSelectedStrokeColor();

        if (node instanceof Rectangle rect) {
            rect.setWidth(width);
            rect.setHeight(height);
            rect.setX(centerX - width / 2);
            rect.setY(centerY - height / 2);
            rect.setFill(fill);
            rect.setStroke(stroke);
        } else if (node instanceof Circle circle) {
            double radius = Math.max(width, height) / 2;
            circle.setRadius(radius);
            circle.setCenterX(centerX);
            circle.setCenterY(centerY);
            circle.setFill(fill);
            circle.setStroke(stroke);
        } else if (node instanceof Line line) {
            line.setStartX(startX);
            line.setStartY(startY);
            line.setEndX(endX);
            line.setEndY(endY);
            line.setStroke(stroke);
        }

        view.getDrawingPane().getChildren().add(node);
        log("Drew " + selectedShape + " from (" + startX + ", " + startY + ") to (" + endX + ", " + endY + ")");
    }

    private void log(String message) {
        logger.log(message);
        view.getLogArea().appendText(message + "\n");
    }
}
