package org.swproject.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.swproject.model.CanvasObject;

public class LineObject extends CanvasObject {

    public LineObject(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1, x2, y2);
    }

    @Override
    public void move(int dx, int dy) {
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public int getX() {
        return Math.min(x1, x2);
    }

    @Override
    public int getY() {
        return Math.min(y1, y2);
    }

    @Override
    public int getWidth() {
        return Math.abs(x2 - x1);
    }

    @Override
    public int getHeight() {
        return Math.abs(y2 - y1);
    }

    @Override
    public void setX(int x) {
        x1 = x;
    }

    @Override
    public void setY(int y) {
        y1 = y;
    }

    @Override
    public void setWidth(int width) {
        x2 = x1 + width;
    }

    @Override
    public void setHeight(int height) {
        y2 = y1 + height;
    }

}
