package org.swproject.command;

import org.swproject.model.Model;

public class SetHeightCommand extends UndoableCommand {

    Model model;
    int height;
    int oldHeight;

    public SetHeightCommand(Model model, int height) {
        this.model = model;
        this.height = height;
    }

    @Override
    public void undo() {
        model.setHeight(oldHeight);
        model.notifyObserver();
        model.notifyObserverClickedObjects();
    }

    @Override
    public void execute() {
        oldHeight = model.getCanvasObjectComposite().getHeight();
        model.setHeight(height);
    }
}
