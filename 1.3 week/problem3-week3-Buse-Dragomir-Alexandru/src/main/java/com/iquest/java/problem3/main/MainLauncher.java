package com.iquest.java.problem3.main;

import com.iquest.java.problem3.canvas.Canvas;
import com.iquest.java.problem3.canvas.SimpleCanvas;
import com.iquest.java.problem3.editor.SimpleGraphicalObjectEditor;
import com.iquest.java.problem3.shape.Shape;
import com.iquest.java.problem3.shape.Circle;
import com.iquest.java.problem3.shape.Line;
import com.iquest.java.problem3.shape.Point;
import com.iquest.java.problem3.shape.Rectangle;

public class MainLauncher {

    public static void main(String[] args) {

        // creating shapes
        int radius = 4;

        Point point = new Point(2, 3);
        Point firstPoint = new Point(3, 4);
        Point secondPoint = new Point(6, 9);
        Point centerPoint = new Point(4, 4);
        Point upperLeftPoint = new Point(1, 2);
        Point upperRightPoint = new Point(6, 2);
        Point bottomLeftPoint = new Point(1, 0);
        Point bottomRightPoint = new Point(6, 0);

        Line line = new Line(firstPoint, secondPoint);
        Circle circle = new Circle(centerPoint, radius);
        Rectangle rectangle = new Rectangle(upperLeftPoint, upperRightPoint,
                                            bottomLeftPoint, bottomRightPoint);

        // creating the base canvas and the additional canvas which are both canvases and shapes
        // as they implement both the shape and the canvas interfaces
        SimpleCanvas baseCanvas = new SimpleCanvas(30, 40);
        SimpleCanvas additionalCanvas = new SimpleCanvas(20, 30);

        // creating the graphical object editor
        SimpleGraphicalObjectEditor graphicalObjectEditor =
                new SimpleGraphicalObjectEditor(baseCanvas);

        // adding shapes to the base canvas
        graphicalObjectEditor.addShapeToCanvas(point, baseCanvas);
        graphicalObjectEditor.addShapeToCanvas(line, baseCanvas);
        graphicalObjectEditor.addShapeToCanvas(circle, baseCanvas);
        graphicalObjectEditor.addShapeToCanvas(rectangle, baseCanvas);
        System.out.println(point + "\nHas been added to the base canvas\n");
        System.out.println(line + "\nHas been added to the base canvas\n");
        System.out.println(circle + "\nHas been added to the base canvas\n");
        System.out.println(rectangle + "\nHas been added to the base canvas\n");
        System.out.println("Number of shapes on base canvas: " +
                baseCanvas.getNumberOfShapesOnCanvas() + "\n");

        // adding shapes to the additional canvas
        graphicalObjectEditor.addShapeToCanvas(point, additionalCanvas);
        System.out.println(point + "\nHas been added to the additional canvas\n");
        System.out.println("Number of shapes on additional canvas: " +
                additionalCanvas.getNumberOfShapesOnCanvas() + "\n");
        graphicalObjectEditor.removeShapeFromCanvas(point, additionalCanvas);
        System.out.println("The point has been removed from the additional canvas\n");
        System.out.println("Number of shapes on additional canvas: " +
                additionalCanvas.getNumberOfShapesOnCanvas() + "\n");

        // adding the additional canvas on the base canvas
        graphicalObjectEditor.addShapeToCanvas(additionalCanvas, baseCanvas);
        System.out.println(additionalCanvas + "\nHas been added to the base canvas\n");
        System.out.println("Number of shapes on base canvas: " +
                            baseCanvas.getNumberOfShapesOnCanvas() + "\n");

        // removing the additional canvas and the rectangle from the base canvas
        graphicalObjectEditor.removeShapeFromCanvas(additionalCanvas, baseCanvas);
        graphicalObjectEditor.removeShapeFromCanvas(rectangle, baseCanvas);
        System.out.println("The additional canvas has been removed from the base canvas");
        System.out.println("The rectangle has been removed from the base canvas");
        System.out.println("\nNumber of shapes on base canvas: " +
                baseCanvas.getNumberOfShapesOnCanvas());
    }
}
