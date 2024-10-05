package com.iquest.java.problem3.shape;

public class Rectangle implements Shape {

    private Point upperLeftPoint;
    private Point bottomLeftPoint;
    private Point upperRightPoint;
    private Point bottomRightPoint;

    private Line upperLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;

    public Rectangle(Point upperLeftPoint, Point upperRightPoint,
                     Point bottomLeftPoint, Point bottomRightPoint) {
        this.upperLeftPoint = upperLeftPoint;
        this.upperRightPoint = upperRightPoint;
        this.bottomLeftPoint = bottomLeftPoint;
        this.bottomRightPoint = bottomRightPoint;

        this.upperLine = new Line(upperLeftPoint, upperRightPoint);
        this.bottomLine = new Line(bottomLeftPoint, bottomRightPoint);
        this.leftLine = new Line(upperLeftPoint, bottomLeftPoint);
        this.rightLine = new Line(upperRightPoint, bottomRightPoint);
    }

    @Override
    public double calculateArea() {
        double upperSideLength = this.upperLine.getDistanceBetweenLinePoints();
        double leftSideLength = this.leftLine.getDistanceBetweenLinePoints();
        return upperSideLength * leftSideLength;
    }

    @Override
    public double calculatePerimeter() {
        double sideLength = this.upperLine.getDistanceBetweenLinePoints();
        double leftSideLength = this.leftLine.getDistanceBetweenLinePoints();
        return 2 * (sideLength + leftSideLength);
    }

    @Override
    public boolean isShapeInsideArea(int areaLength, int areaHeight) {
        Point upperLeftPoint = this.upperLeftPoint;
        Point upperRightPoint = this.upperRightPoint;
        Point bottomLeftPoint = this.bottomLeftPoint;
        Point bottomRightPoint = this.bottomRightPoint;

        return upperLeftPoint.isShapeInsideArea(areaLength, areaHeight) &&
               upperRightPoint.isShapeInsideArea(areaLength, areaHeight) &&
               bottomLeftPoint.isShapeInsideArea(areaLength, areaHeight) &&
               bottomRightPoint.isShapeInsideArea(areaLength, areaHeight);
    }

    @Override
    public boolean isShapeValid() {
        return this.upperLeftPoint.isShapeValid() &&
               this.upperRightPoint.isShapeValid() &&
               this.bottomLeftPoint.isShapeValid() &&
               this.bottomRightPoint.isShapeValid() &&
               this.upperLeftPoint.getCoordinateX() == this.bottomLeftPoint.getCoordinateX() &&
               this.upperLeftPoint.getCoordinateY() == this.upperRightPoint.getCoordinateY() &&
               this.upperRightPoint.getCoordinateX() == this.bottomRightPoint.getCoordinateX() &&
               this.bottomLeftPoint.getCoordinateY() == this.bottomRightPoint.getCoordinateY();
    }

    @Override
    public String toString() {
        return "Rectangle made of four lines: \n" + this.upperLine + "\n" +
                this.rightLine + "\n" + this.bottomLine + "\n" + this.leftLine +
                "\nThe rectangle has a perimeter of " +
                this.calculatePerimeter() + " and an area of " + this.calculateArea();
    }
}
