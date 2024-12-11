package org.swproject.command;

import org.swproject.model.Model;

public class SetWidthCommand extends UndoableCommand {

    Model model;
    int width;
    int oldWidth;

    public SetWidthCommand(Model model, int width) {
        this.model = model;
        this.width = width;
    }

    @Override
    public void undo() {
        model.setWidth(oldWidth);
        model.notifyObserver();
        model.notifyObserverClickedObjects();
    }

    @Override
    public void execute() {
        oldWidth = model.getCanvasObjectComposite().getWidth();
        model.setWidth(width);
    }
}
