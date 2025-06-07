package com.example.mypaint.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DrawingView {
    private BorderPane root;
    private Pane drawingPane;
    private ToolBar toolBar;
    private Button rectangleButton, circleButton, lineButton;

    public DrawingView() {
        root = new BorderPane();
        drawingPane = new Pane();
        drawingPane.setStyle("-fx-background-color: white;");

        rectangleButton = new Button("Rectangle");
        circleButton = new Button("Circle");
        lineButton = new Button("Line");

        toolBar = new ToolBar(rectangleButton, circleButton, lineButton);
        toolBar.setPadding(new Insets(5));

        root.setTop(toolBar);
        root.setCenter(drawingPane);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Pane getDrawingPane() {
        return drawingPane;
    }

    public Button getRectangleButton() {
        return rectangleButton;
    }

    public Button getCircleButton() {
        return circleButton;
    }

    public Button getLineButton() {
        return lineButton;
    }
}
