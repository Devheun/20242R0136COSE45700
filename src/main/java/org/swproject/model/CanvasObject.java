package org.swproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class CanvasObject implements CanvasObjectInterface {

    protected Color color;
    protected int id;
    protected int x, y;
    protected int width, height;

    public CanvasObject(Color color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public abstract void draw(Graphics2D g);

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public boolean contains(Point point) {
        return (point.x >= x && point.x <= x + width && point.y >= y && point.y <= y + height);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
