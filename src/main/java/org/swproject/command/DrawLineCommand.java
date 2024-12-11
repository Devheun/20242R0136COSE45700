package org.swproject.command;

import java.awt.Color;
import org.swproject.model.Model;
import org.swproject.model.object.LineObject;

public class DrawLineCommand extends DrawCommand {

    public DrawLineCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
        super(model, color, x1, y1, x2, y2);
    }

    @Override
    public void execute() {
        this.canvasObject = new LineObject(this.color, this.x1, this.y1, this.x2, this.y2);
        this.model.createCanvasObject(this.canvasObject);
    }
}
