package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.swproject.model.CanvasObjectComposite;
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
    public void mouseDragged(MouseEvent event) {
        CanvasObjectComposite canvasObject = model.getCanvasObjectComposite();
        canvasObject.handleResizing(event, canvasObject.getX(), canvasObject.getY(), canvasObject.getWidth(),
                canvasObject.getHeight());
        model.notifyObserverClickedObjects();
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }
}
