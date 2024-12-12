package org.swproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CanvasObjectComposite implements CanvasObjectInterface {

    private final List<CanvasObjectInterface> canvasObjects = new ArrayList<>();

    public void add(CanvasObjectInterface canvasObject) {
        canvasObjects.add(canvasObject);
    }

    public void remove(CanvasObjectInterface canvasObject) {
        canvasObjects.remove(canvasObject);
    }

    public boolean isAlreadySelected(CanvasObjectInterface canvasObject) {
        return canvasObjects.contains(canvasObject);
    }

    public List<CanvasObjectInterface> getCanvasObjects() {
        return canvasObjects;
    }

    public Color getColor() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getColor();
        }
        return null;
    }

    @Override
    public void draw(Graphics2D g) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.draw(g);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.move(dx, dy);
        }
    }

    @Override
    public boolean isPointerInside(Point point) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            if (canvasObject.isPointerInside(point)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isResizable(Point point) {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().isResizable(point);
        }
        return false;
    }

    @Override
    public int getId() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getId();
        }
        return -1;
    }

    @Override
    public int getX() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getX();
        }
        return 0;
    }

    @Override
    public int getY() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getY();
        }
        return 0;
    }

    @Override
    public int getWidth() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getWidth();
        }
        return 0;
    }

    @Override
    public int getHeight() {
        if (canvasObjects.size() == 1) {
            return canvasObjects.getFirst().getHeight();
        }
        return 0;
    }

    @Override
    public void setColor(Color color) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.setColor(color);
        }
    }

    @Override
    public void setX(int x) {
        if (canvasObjects.size() == 1) {
            canvasObjects.getFirst().setX(x);
        }
    }

    @Override
    public void setY(int y) {
        if (canvasObjects.size() == 1) {
            canvasObjects.getFirst().setY(y);
        }
    }

    @Override
    public void setWidth(int width) {
        if (canvasObjects.size() == 1) {
            canvasObjects.getFirst().setWidth(width);
        }
    }

    @Override
    public void setHeight(int height) {
        if (canvasObjects.size() == 1) {
            canvasObjects.getFirst().setHeight(height);
        }
    }
}
