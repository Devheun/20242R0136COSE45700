package org.swproject.model;

import java.awt.Point;
import java.util.ArrayList;
import org.swproject.observer.Observer;
import org.swproject.observer.Subject;

public class Model implements Subject {
    private final ArrayList<CanvasObjectInterface> canvasObjects = new ArrayList<>();
    private final ArrayList<Observer> observers = new ArrayList<>();

    public void createCanvasObject(CanvasObject canvasObject) {
        int size = canvasObjects.size();
        if (size == 0) {
            canvasObject.setId(0);
        } else {
            canvasObject.setId(canvasObjects.get(size - 1).getId() + 1);
        }

        canvasObjects.add(canvasObject);
        notifyObserver();
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


    @Override
    public void attachObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void detachObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.updateCanvasObjects(canvasObjects);
        }
    }
}
