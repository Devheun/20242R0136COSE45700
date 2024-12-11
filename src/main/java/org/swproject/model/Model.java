package org.swproject.model;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.swproject.observer.Observer;
import org.swproject.observer.Subject;

public class Model implements Subject {
    private static final ArrayList<CanvasObjectInterface> canvasObjects = new ArrayList<>();
    private static final ArrayList<Observer> observers = new ArrayList<>();

    private static final CanvasObjectComposite canvasObjectComposite = new CanvasObjectComposite();
    private int mouseX, mouseY;

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

    public void updateCanvasObject() {
        notifyObserver();
    }

    public void removeCanvasObject(CanvasObjectInterface canvasObject) {
        canvasObjects.remove(canvasObject);
        notifyObserver();
    }

    public CanvasObjectInterface getCanvasObjectAtPoint(Point point) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            if (canvasObject.isPointerInside(point)) {
                return canvasObject;
            }
        }
        return null;
    }

    public void handleMouseClick(CanvasObjectInterface canvasObject) {
        if (canvasObjectComposite.isAlreadySelected(canvasObject)) {
            canvasObjectComposite.remove(canvasObject);
        } else {
            canvasObjectComposite.add(canvasObject);
        }
        notifyObserverClickedObjects();
    }

    public void handleMousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void handleMouseDragged(MouseEvent e) {
        int dx = e.getX() - mouseX;
        int dy = e.getY() - mouseY;
        mouseX = e.getX();
        mouseY = e.getY();
        canvasObjectComposite.move(dx, dy);
        notifyObserver();
        notifyObserverClickedObjects();
    }

    public void handleResizing(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        CanvasObjectInterface obj = canvasObjectComposite.getCanvasObjects().getFirst();
        if (obj != null) {
            int dx = mouseX - obj.getX();
            int dy = mouseY - obj.getY();
            obj.setWidth(dx);
            obj.setHeight(dy);
            notifyObserver();
            notifyObserverClickedObjects();
        }
    }

    public CanvasObjectComposite getCanvasObjectComposite() {
        return canvasObjectComposite;
    }

    public void notifyObserverClickedObjects() {
        for (Observer observer : observers) {
            observer.updateSelectedCanvasObjects(canvasObjectComposite);
        }
    }

    public void placeObjectToFront() {
        for (CanvasObjectInterface canvasObject : canvasObjectComposite.getCanvasObjects()) {
            // 리스트에 들어가는 순서 변경하기
            canvasObjects.remove(canvasObject);
            canvasObjects.addFirst(canvasObject);
        }
        notifyObserver();
        notifyObserverClickedObjects();
    }

    public void placeObjectToBack() {
        for (CanvasObjectInterface canvasObject : canvasObjectComposite.getCanvasObjects()) {
            // 리스트에 들어가는 순서 변경하기
            canvasObjects.remove(canvasObject);
            canvasObjects.add(canvasObject);
        }
        notifyObserver();
        notifyObserverClickedObjects();
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
