package org.swproject.command;

import java.awt.Color;
import org.swproject.model.Model;

public class SetColorCommand extends UndoableCommand {
    Model model;
    Color color;
    Color oldColor;

    public SetColorCommand(Model model, Color color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void undo() {
        model.setColor(oldColor);
        model.notifyObserver();
        model.notifyObserverClickedObjects();
    }

    @Override
    public void execute() {
        oldColor = model.getCanvasObjectComposite().getColor();
        model.setColor(color);
    }
}
