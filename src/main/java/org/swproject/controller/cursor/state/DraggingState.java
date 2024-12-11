package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
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
    public void mouseDragged(MouseEvent event) {
        model.handleMouseDragged(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }
}
