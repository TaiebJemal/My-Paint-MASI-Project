package com.example.mypaint.model;

import javafx.scene.Node;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public Node draw() {
        return decoratedShape.draw();
    }
}
