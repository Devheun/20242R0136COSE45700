package org.swproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface CanvasObjectInterface {
    void resize(int x, int y, int width, int height);

    void draw(Graphics2D g);

    void setColor(Color color);

    void move(int dx, int dy);

    boolean isPointerInside(Point point);

    boolean isResizable(Point point);

    int getId();

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
