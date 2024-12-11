package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.command.CommandInvoker;
import org.swproject.command.ResizeCommand;
import org.swproject.model.Model;

public class ResizingState implements CursorState {

    private static ResizingState instance;
    private final Model model;

    public ResizingState(Model model) {
        this.model = model;
    }

    public static ResizingState getInstance(Model model) {
        if (instance == null) {
            instance = new ResizingState(model);
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
        ResizeCommand resizeCommand = new ResizeCommand(model, event);
        CommandInvoker.getInstance().executeCommand(resizeCommand);
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }
}
