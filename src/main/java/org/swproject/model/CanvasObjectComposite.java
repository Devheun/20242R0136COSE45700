package org.swproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CanvasObjectComposite implements CanvasObjectInterface {

    private final List<CanvasObjectInterface> canvasObjects = new ArrayList<>();

    private int mouseX, mouseY;

    public void add(CanvasObjectInterface canvasObject) {
        canvasObjects.add(canvasObject);
    }

    public void remove(CanvasObjectInterface canvasObject) {
        canvasObjects.remove(canvasObject);
    }

    public boolean isAlreadySelected(CanvasObjectInterface canvasObject) {
        return canvasObjects.contains(canvasObject);
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
        move(dx, dy);
    }

    @Override
    public void resize(int x, int y, int width, int height) {
        if (canvasObjects.size() == 1) {
            canvasObjects.getFirst().resize(x, y, width, height);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.draw(g);
        }
    }

    @Override
    public void setColor(Color color) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.setColor(color);
        }
    }


    @Override
    public void move(int dx, int dy) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            canvasObject.move(dx, dy);
        }
    }

    @Override
    public boolean contains(Point point) {
        for (CanvasObjectInterface canvasObject : canvasObjects) {
            if (canvasObject.contains(point)) {
                return true;
            }
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
}
