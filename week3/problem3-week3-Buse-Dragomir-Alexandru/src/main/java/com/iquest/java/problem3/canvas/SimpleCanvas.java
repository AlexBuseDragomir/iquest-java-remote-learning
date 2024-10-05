package com.iquest.java.problem3.canvas;

import com.iquest.java.problem3.shape.*;

import java.util.ArrayList;
import java.util.List;

public class SimpleCanvas implements Canvas, Shape {

    private int canvasLength;
    private int canvasHeight;
    private List<Shape> shapeList;

    public SimpleCanvas(int canvasLength, int canvasHeight) {
        this.canvasLength = canvasLength;
        this.canvasHeight = canvasHeight;
        this.shapeList = new ArrayList<>();
    }

    /// methods from the Canvas interface

    @Override
    public void addShapeToCanvas(Shape shapeToAdd) {

        if (shapeToAdd.isShapeValid()) {
            if (doesShapeFitOnCanvas(shapeToAdd))
            {
                this.shapeList.add(shapeToAdd);
            } else {
                System.err.println("ERROR: The shape does not fit inside the canvas");
            }
        } else {
            System.err.println("ERROR: The shape is not a valid one");
        }
    }

    @Override
    public void removeShapeFromCanvas(Shape shapeToRemove) {
        this.shapeList.remove(shapeToRemove);
    }

    @Override
    public boolean doesShapeFitOnCanvas(Shape shapeToAdd) {
        return shapeToAdd.isShapeInsideArea(this.canvasLength, this.canvasHeight);
    }

    @Override
    public int getCanvasLength() {
        return this.canvasLength;
    }

    @Override
    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    @Override
    public int getNumberOfShapesOnCanvas() {
        return this.shapeList.size();
    }

    /// methods from the Shape interface

    public double calculateArea() {
        return this.canvasHeight * this.canvasLength;
    }

    public double calculatePerimeter() {
        return 2 * (this.canvasHeight + this.canvasLength);
    }

    public boolean isShapeInsideArea(int areaLength, int areaHeight) {
        return this.canvasLength <= areaLength &&
                this.canvasHeight <= areaHeight;
    }

    public boolean isShapeValid() {
        return this.canvasHeight > 0 && this.getCanvasLength() > 0;
    }

    @Override
    public String toString() {
        return "Canvas with a number of " + this.getNumberOfShapesOnCanvas() +
                " shapes on it";
    }
}
