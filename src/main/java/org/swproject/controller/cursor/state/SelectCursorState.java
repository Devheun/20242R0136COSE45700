package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.model.CanvasObjectComposite;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.Model;

public class SelectCursorState implements CursorState {

    private final Model model;
    private boolean isResizing = false;

    public SelectCursorState(Model model) {
        this.model = model;
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
        if (canvasObject.isResizable(event.getPoint())) {
            isResizing = true;
        }
        canvasObject.handleMousePressed(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        CanvasObjectComposite canvasObject = model.getCanvasObjectComposite();
        if (isResizing) {
            canvasObject.handleResizing(event, canvasObject.getX(), canvasObject.getY(), canvasObject.getWidth(),
                    canvasObject.getHeight());
        } else {
            canvasObject.handleMouseDragged(event);
        }
        model.notifyObserverClickedObjects();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        isResizing = false;
    }
}
