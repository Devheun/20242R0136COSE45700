package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.command.CommandInvoker;
import org.swproject.command.MoveCommand;
import org.swproject.model.Model;

public class DraggingState implements CursorState {

    private static DraggingState instance; // 싱글톤으로 state 관리
    private final Model model;

    public DraggingState(Model model) {
        this.model = model;
    }

    public static DraggingState getInstance(Model model) {
        if (instance == null) {
            instance = new DraggingState(model);
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseDragged(MouseEvent event, int dx, int dy) {
        MoveCommand moveCommand = new MoveCommand(model, dx, dy);
        CommandInvoker.getInstance().executeCommand(moveCommand);
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }
}
