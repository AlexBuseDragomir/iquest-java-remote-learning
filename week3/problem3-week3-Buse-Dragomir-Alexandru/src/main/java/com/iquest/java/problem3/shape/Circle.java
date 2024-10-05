package com.iquest.java.problem3.shape;

public class Circle implements Shape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public boolean isShapeInsideArea(int areaLength, int areaHeight) {
        int coordinateX = this.center.getCoordinateX();
        int coordinateY = this.center.getCoordinateY();

        return coordinateX + this.radius <= areaLength &&
               coordinateY + this.radius <= areaHeight &&
               coordinateX - this.radius >= 0 && coordinateY - this.radius >= 0;
    }

    @Override
    public boolean isShapeValid() {
        return this.center.isShapeValid() && this.radius > 0;
    }

    public String toString() {
        return "Circle that has a center: \n" + this.center +
                " and a radius of " + this.radius +
                "\nThe circle has a perimeter of " + this.calculatePerimeter() +
                " and an area of " + this.calculateArea();
    }
}
