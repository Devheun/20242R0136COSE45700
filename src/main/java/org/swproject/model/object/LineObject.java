package org.swproject.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.swproject.model.CanvasObject;

public class LineObject extends CanvasObject {
    private int x2;
    private int y2;

    public LineObject(Color color, int id, int x, int y, int width, int height, int x2, int y2) {
        super(color, id, x, y, width, height);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        this.x2 += dx;
        this.y2 += dy;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(x, y, x2, y2);
    }

}
