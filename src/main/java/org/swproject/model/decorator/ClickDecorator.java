package org.swproject.model.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import org.swproject.model.CanvasObjectInterface;

public class ClickDecorator implements CanvasObjectInterface {

    private final CanvasObjectInterface canvasObject;

    public ClickDecorator(CanvasObjectInterface canvasObject) {
        this.canvasObject = canvasObject;
        setColor(Color.RED);
    }

    @Override
    public void resize(int x, int y, int width, int height) {
        canvasObject.resize(x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        canvasObject.draw(g);
    }

    @Override
    public void setColor(Color color) {
        canvasObject.setColor(color);
    }

    @Override
    public void move(int dx, int dy) {
        canvasObject.move(dx, dy);
    }

    @Override
    public boolean contains(Point point) {
        return canvasObject.contains(point);
    }

    @Override
    public int getId() {
        return canvasObject.getId();
    }

    @Override
    public int getX() {
        return canvasObject.getX();
    }

    @Override
    public int getY() {
        return canvasObject.getY();
    }

    @Override
    public int getWidth() {
        return canvasObject.getWidth();
    }

    @Override
    public int getHeight() {
        return canvasObject.getHeight();
    }
}
