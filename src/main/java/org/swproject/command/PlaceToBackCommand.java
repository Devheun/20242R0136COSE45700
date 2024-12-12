package org.swproject.command;

import org.swproject.model.Model;

public class PlaceToBackCommand implements Command {
    Model model;

    public PlaceToBackCommand(Model model) {
        this.model = model;
    }

    @Override
    public void undo() {
    }

    @Override
    public void execute() {
        model.placeObjectToBack();
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
