package org.swproject.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.swproject.model.CanvasObject;

public class EllipseObject extends CanvasObject {

    public EllipseObject(Color color, int id, int x, int y, int width, int height) {
        super(color, id, x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

}
