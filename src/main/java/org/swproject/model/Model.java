package org.swproject.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<CanvasObjectInterface> canvasObjects = new ArrayList<>();

    public void createCanvasObject(CanvasObject canvasObject) {
        int size = canvasObjects.size();
        if (size == 0) {
            canvasObject.setId(0);
        } else {
            canvasObject.setId(canvasObjects.get(size - 1).getId() + 1);
        }

        canvasObjects.add(canvasObject);
    }

    public void updateCanvasObject(CanvasObject canvasObject) {
    }

    public CanvasObjectInterface getCanvasObjectAtPoint(Point point) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            if (canvasObject.contains(point)) {
                return canvasObject;
            }
        }
        return null;
    }


}
