package com.example.mypaint.model;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class BorderDecorator extends ShapeDecorator {
    public BorderDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public Node draw() {
        Node node = super.draw();
        if (node instanceof javafx.scene.shape.Shape fxShape) {
            fxShape.setStroke(Color.DARKBLUE);
            fxShape.setStrokeWidth(4);
        }
        return node;
    }
}
