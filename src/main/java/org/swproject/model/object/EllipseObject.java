package org.swproject.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.swproject.model.CanvasObject;

public class EllipseObject extends CanvasObject {
    private int x, y, width, height;
    private final int MIN_WIDTH = 10, MIN_HEIGHT = 10;

    public EllipseObject(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1, x2, y2);
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        width = Math.abs(x2 - x1);
        height = Math.abs(y2 - y1);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        x += dx;
        y += dy;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
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

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setWidth(int width) {
        this.width = Math.max(width, MIN_WIDTH);
        this.x2 = this.x1 + this.width;
    }

    @Override
    public void setHeight(int height) {
        this.height = Math.max(height, MIN_HEIGHT);
        this.y2 = this.y1 + this.height;
    }

}
