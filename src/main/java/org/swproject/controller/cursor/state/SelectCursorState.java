package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.model.CanvasObjectComposite;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.Model;

public class SelectCursorState implements CursorState {

    private final Model model;
    private CursorState currentState;

    public SelectCursorState(Model model) {
        this.model = model;
        this.currentState = DraggingState.getInstance(model); // 디폴트로 Dragging state로 설정
    }

    public void changeState(CursorState state) {
        this.currentState = state;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        CanvasObjectInterface canvasObject = model.getCanvasObjectAtPoint(event.getPoint());
        if (canvasObject != null) {
            model.handleMouseClick(canvasObject);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        CanvasObjectComposite canvasObject = model.getCanvasObjectComposite();
        canvasObject.handleMousePressed(event);
        if (canvasObject.isResizable(event.getPoint())) {
            changeState(ResizingState.getInstance(model));
        } else {
            changeState(DraggingState.getInstance(model));
        }
        currentState.mousePressed(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        currentState.mouseDragged(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        currentState.mouseReleased(event);
        changeState(DraggingState.getInstance(model));
    }
}
