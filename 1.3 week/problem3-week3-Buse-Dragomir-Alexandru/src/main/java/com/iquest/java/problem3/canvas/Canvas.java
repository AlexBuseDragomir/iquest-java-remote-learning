package com.iquest.java.problem3.canvas;

import com.iquest.java.problem3.shape.Shape;

public interface Canvas {

    void addShapeToCanvas(Shape shapeToAdd);
    void removeShapeFromCanvas(Shape shapeToRemove);
    boolean doesShapeFitOnCanvas(Shape shapeToAdd);
    int getCanvasLength();
    int getCanvasHeight();
    int getNumberOfShapesOnCanvas();
}
