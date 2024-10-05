package com.iquest.java.problem3.editor;

import com.iquest.java.problem3.canvas.Canvas;
import com.iquest.java.problem3.shape.Shape;

public interface GraphicalObjectEditor {

    void addShapeToCanvas(Shape shapeToAdd, Canvas canvasToAddTo);
    void removeShapeFromCanvas(Shape shapeToRemove, Canvas canvasToRemoveFrom);
}
