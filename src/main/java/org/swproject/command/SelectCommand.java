package org.swproject.command;

import java.awt.event.MouseEvent;
import org.swproject.model.Model;


public class SelectCommand implements Command {

    Model model;
    MouseEvent mouseEvent;

    public SelectCommand(Model model, MouseEvent mouseEvent) {
        this.model = model;
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void undo() {
    }

    @Override
    public void execute() {
        model.handleMousePressed(mouseEvent);
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
