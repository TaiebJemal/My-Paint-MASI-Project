package com.example.mypaint.factory;

import com.example.mypaint.model.CircleShape;
import com.example.mypaint.model.LineShape;
import com.example.mypaint.model.RectangleShape;
import com.example.mypaint.model.Shape;

public class ShapeFactory {
    public static Shape createShape(String type) {
        return switch (type.toLowerCase()) {
            case "rectangle" -> new RectangleShape();
            case "circle" -> new CircleShape();
            case "line" -> new LineShape();
            default -> throw new IllegalArgumentException("Invalid shape type: " + type);
        };
    }
}
