package com.iquest.java.problem3.editor;

import com.iquest.java.problem3.canvas.Canvas;
import com.iquest.java.problem3.shape.Shape;

public class SimpleGraphicalObjectEditor implements GraphicalObjectEditor {

    private Canvas baseCanvas;

    public SimpleGraphicalObjectEditor(Canvas baseCanvas) {
        this.baseCanvas = baseCanvas;
    }

    @Override
    public void addShapeToCanvas(Shape shapeToAdd, Canvas canvasToAddTo) {
        canvasToAddTo.addShapeToCanvas(shapeToAdd);
    }

    @Override
    public void removeShapeFromCanvas(Shape shapeToRemove, Canvas canvasToRemoveFrom) {
        canvasToRemoveFrom.removeShapeFromCanvas(shapeToRemove);
    }

    public Canvas getBaseCanvas() {
        return this.baseCanvas;
    }
}
