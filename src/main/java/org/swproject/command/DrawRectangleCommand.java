package org.swproject.command;

import java.awt.Color;
import org.swproject.model.Model;
import org.swproject.model.object.RectangleObject;

public class DrawRectangleCommand extends DrawCommand {

    public DrawRectangleCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
        super(model, color, x1, y1, x2, y2);
    }

    @Override
    public void execute() {
        this.canvasObject = new RectangleObject(this.color, this.x1, this.y1, this.x2, this.y2);
        this.model.createCanvasObject(this.canvasObject);
    }
}
