package org.swproject.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface CanvasObjectInterface {

    void draw(Graphics2D g);

    void move(int dx, int dy);

    boolean isPointerInside(Point point);

    boolean isResizable(Point point);

    int getId();

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void setColor(Color color);

    void setX(int x);

    void setY(int y);

    void setWidth(int width);

    void setHeight(int height);

}
