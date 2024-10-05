package com.iquest.java.problem3.shape;

import static java.lang.Double.NaN;

public class Line implements Shape {

    private Point firstPoint;
    private Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
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
        return this.firstPoint.isShapeInsideArea(areaLength, areaHeight) &&
               this.secondPoint.isShapeInsideArea(areaLength, areaHeight);
    }

    @Override
    public boolean isShapeValid() {
        return this.firstPoint.isShapeValid() && this.secondPoint.isShapeValid();
    }

    public double getDistanceBetweenLinePoints() {

        int x1 = this.firstPoint.getCoordinateX();
        int y1 = this.firstPoint.getCoordinateY();
        int x2 = this.secondPoint.getCoordinateX();
        int y2 = this.secondPoint.getCoordinateY();

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    @Override
    public String toString() {
        return "Line made of two points: \n" + this.firstPoint + "\n" +
                this.secondPoint + "\nThe line has a perimeter of " +
                this.calculatePerimeter() + " and an area of " + this.calculateArea();
    }
}
