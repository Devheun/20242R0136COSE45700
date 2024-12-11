package org.swproject.command;

public abstract class UndoableCommand implements Command {
    @Override
    public boolean isUndoable() {
        return true;
    }
}
