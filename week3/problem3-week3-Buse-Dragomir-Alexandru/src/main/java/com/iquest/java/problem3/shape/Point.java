package com.iquest.java.problem3.shape;

import static java.lang.Double.NaN;

public class Point implements  Shape {

    private int coordinateX;
    private int coordinateY;

    public Point(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public double calculateArea() {
        return NaN;
    }

    @Override
    public double calculatePerimeter() {
        return NaN;
    }

    @Override
    public boolean isShapeInsideArea(int areaLength, int areaHeight) {
        return this.getCoordinateX() <= areaLength &&
               this.getCoordinateY() <= areaHeight &&
               this.isShapeValid();
    }

    @Override
    public boolean isShapeValid() {
        return this.coordinateX >= 0 && this.getCoordinateY() >= 0;
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

    @Override
    public String toString() {
        return "Point(" + this.coordinateX + "," + this.coordinateY +
                ") with a perimeter of " + this.calculatePerimeter() +
                " and an area of " + this.calculateArea();
    }
}
