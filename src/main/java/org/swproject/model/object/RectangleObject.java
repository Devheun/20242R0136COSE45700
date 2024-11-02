package org.swproject.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.swproject.model.CanvasObject;

public class RectangleObject extends CanvasObject {

    public RectangleObject(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

}
