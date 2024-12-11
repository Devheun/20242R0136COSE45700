package org.swproject.command;

import org.swproject.model.Model;

public class PlaceToFrontCommand implements Command {

    Model model;

    public PlaceToFrontCommand(Model model) {
        this.model = model;
    }

    @Override
    public void undo() {
    }

    @Override
    public void execute() {
        model.placeObjectToFront();
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
