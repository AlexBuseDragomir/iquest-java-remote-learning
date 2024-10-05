package com.iquest.java.problem3.shape;

public interface Shape {

    double calculateArea();
    double calculatePerimeter();
    boolean isShapeInsideArea(int areaLength, int areaHeight);
    boolean isShapeValid();
}
