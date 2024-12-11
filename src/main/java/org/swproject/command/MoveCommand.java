package org.swproject.command;

import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.Model;

public class MoveCommand extends UndoableCommand {

    Model model;
    int dx, dy;
    CanvasObjectInterface selectedCanvasObjects;

    public MoveCommand(Model model, int dx, int dy) {
        this.model = model;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void undo() {
        selectedCanvasObjects.move(-this.dx, -this.dy);
        model.notifyObserver();
        model.notifyObserverClickedObjects();
    }

    @Override
    public void execute() {
        selectedCanvasObjects = this.model.getCanvasObjectComposite();
        model.handleMouseDragged(dx, dy);
    }
}
