package org.swproject.command;

import java.util.Stack;

public class CommandInvoker {
    private final Stack<Command> executeHistory = new Stack<>();
    private final Stack<Command> undoHistory = new Stack<>();
    private static CommandInvoker instance;

    private CommandInvoker() {
    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        command.execute();
        if (command.isUndoable()) {
            executeHistory.push(command);
        }
        undoHistory.clear();
    }

    public void undo() {
        if (!isUndoable()) {
            return;
        }
        Command command = executeHistory.pop();
        command.undo();
        undoHistory.push(command);
    }

    public void redo() {
        if (!isRedoable()) {
            return;
        }
        Command command = undoHistory.pop();
        command.execute();
        executeHistory.push(command);
    }

    public boolean isUndoable() {
        return !executeHistory.isEmpty();
    }

    public boolean isRedoable() {
        return !undoHistory.isEmpty();
    }
}
