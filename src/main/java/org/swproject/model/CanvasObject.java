package org.swproject.model;

import java.awt.Color;
import java.awt.Point;

public abstract class CanvasObject implements CanvasObjectInterface {
    protected int x1, x2, y1, y2;
    protected Color color;
    protected int id;

    private final int HANDLE_SIZE = 6;

    public CanvasObject(Color color, int x1, int y1, int x2, int y2) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    @Override
    public boolean isPointerInside(Point point) {
        int startX = Math.min(x1, x2);
        int startY = Math.min(y1, y2);
        int endX = Math.max(x1, x2);
        int endY = Math.max(y1, y2);
        return (point.x >= startX && point.x <= endX && point.y >= startY && point.y <= endY);
    }

    @Override
    public boolean isResizable(Point point) {
        int endX = Math.max(x1, x2);
        int endY = Math.max(y1, y2);
        return (point.x >= endX - HANDLE_SIZE / 2 && point.x <= endX + HANDLE_SIZE / 2) && (
                point.y >= endY - HANDLE_SIZE / 2 && point.y <= endY + HANDLE_SIZE / 2);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    
}
