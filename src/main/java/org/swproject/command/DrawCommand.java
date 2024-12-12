package org.swproject.command;

import java.awt.Color;
import org.swproject.model.CanvasObject;
import org.swproject.model.Model;

public abstract class DrawCommand extends UndoableCommand {
    protected CanvasObject canvasObject;
    protected Model model;
    protected int x1, y1, x2, y2;
    protected Color color;

    protected DrawCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
        this.model = model;
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void undo() {
        model.removeCanvasObject(this.canvasObject);
        model.notifyObserver();
    }
}
