package org.swproject.command;

import java.awt.event.MouseEvent;
import org.swproject.model.Model;


public class ResizeCommand extends UndoableCommand {

    Model model;
    MouseEvent mouseEvent;
    int oldWidth, oldHeight;

    public ResizeCommand(Model model, MouseEvent mouseEvent) {
        this.model = model;
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void undo() {
        model.setWidth(oldWidth);
        model.setHeight(oldHeight);
        model.notifyObserver();
    }

    @Override
    public void execute() {
        oldWidth = model.getCanvasObjectComposite().getWidth();
        oldHeight = model.getCanvasObjectComposite().getHeight();
        model.handleResize(mouseEvent);
    }
}
