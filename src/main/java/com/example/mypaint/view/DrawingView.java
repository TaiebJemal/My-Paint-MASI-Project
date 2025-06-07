package com.example.mypaint.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawingView {
    private BorderPane root;
    private Pane drawingPane;
    private ToolBar toolBar;
    private Button rectangleButton, circleButton, lineButton, toggleLogButton;
    private ComboBox<HBox> fillColorBox, strokeColorBox;
    private TextArea logArea;
    private VBox centerBox;

    public DrawingView() {
        root = new BorderPane();
        drawingPane = new Pane();
        drawingPane.setStyle("-fx-background-color: white;");
        drawingPane.setPrefHeight(500);

        rectangleButton = new Button("Rectangle");
        circleButton = new Button("Circle");
        lineButton = new Button("Line");

        toggleLogButton = new Button("Logging View");

        fillColorBox = new ComboBox<>();
        strokeColorBox = new ComboBox<>();

        addColorOption(fillColorBox, "Red", Color.web("#FF0000"));
        addColorOption(fillColorBox, "Blue", Color.web("#0000FF"));
        addColorOption(fillColorBox, "Green", Color.web("#00FF00"));
        addColorOption(fillColorBox, "Yellow", Color.web("#FFFF00"));
        addColorOption(fillColorBox, "Black", Color.web("#000000"));
        addColorOption(fillColorBox, "White", Color.web("#FFFFFF"));
        addColorOption(fillColorBox, "Cyan", Color.web("#00FFFF"));
        addColorOption(fillColorBox, "Magenta", Color.web("#FF00FF"));
        addColorOption(fillColorBox, "Gray", Color.web("#808080"));
        addColorOption(fillColorBox, "Orange", Color.web("#FFA500"));

        addColorOption(strokeColorBox, "Red", Color.web("#FF0000"));
        addColorOption(strokeColorBox, "Blue", Color.web("#0000FF"));
        addColorOption(strokeColorBox, "Green", Color.web("#00FF00"));
        addColorOption(strokeColorBox, "Yellow", Color.web("#FFFF00"));
        addColorOption(strokeColorBox, "Black", Color.web("#000000"));
        addColorOption(strokeColorBox, "White", Color.web("#FFFFFF"));
        addColorOption(strokeColorBox, "Cyan", Color.web("#00FFFF"));
        addColorOption(strokeColorBox, "Magenta", Color.web("#FF00FF"));
        addColorOption(strokeColorBox, "Gray", Color.web("#808080"));
        addColorOption(strokeColorBox, "Orange", Color.web("#FFA500"));

        fillColorBox.getSelectionModel().select(0);
        strokeColorBox.getSelectionModel().select(4);

        HBox colorBox = new HBox(10,
                new Label("Fill Color:"), fillColorBox,
                new Label("Stroke Color:"), strokeColorBox);
        colorBox.setPadding(new Insets(5));

        toolBar = new ToolBar(toggleLogButton, rectangleButton, circleButton, lineButton);
        toolBar.setPadding(new Insets(5));

        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(200);
        logArea.setStyle("-fx-font-family: monospace; -fx-font-size: 12px;");

        centerBox = new VBox();
        centerBox.getChildren().addAll(drawingPane, logArea);

        VBox topBox = new VBox(toolBar, colorBox);

        root.setTop(topBox);
        root.setCenter(centerBox);
    }

    private void addColorOption(ComboBox<HBox> comboBox, String name, Color color) {
        Rectangle swatch = new Rectangle(15, 15, color);
        Label label = new Label(name + " (" + color.toString() + ")");
        HBox item = new HBox(5, swatch, label);
        item.setUserData(color);
        comboBox.getItems().add(item);
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

    public TextArea getLogArea() {
        return logArea;
    }

    public Color getSelectedFillColor() {
        HBox selected = fillColorBox.getValue();
        return (Color) selected.getUserData();
    }

    public Color getSelectedStrokeColor() {
        HBox selected = strokeColorBox.getValue();
        return (Color) selected.getUserData();
    }

    public Button getToggleLogButton() {
        return toggleLogButton;
    }

    public VBox getCenterBox() {
        return centerBox;
    }
}