package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.model.CanvasObjectComposite;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.Model;

public class SelectCursorState implements CursorState {

    private final Model model;

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
        canvasObject.handleMousePressed(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        CanvasObjectComposite canvasObject = model.getCanvasObjectComposite();
        canvasObject.handleMouseDragged(event);
        model.notifyObserverClickedObjects();
    }
}
