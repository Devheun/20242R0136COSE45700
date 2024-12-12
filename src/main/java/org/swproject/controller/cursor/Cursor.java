package org.swproject.controller.cursor;

import java.awt.event.MouseEvent;
import org.swproject.controller.cursor.state.CursorState;
import org.swproject.controller.cursor.state.DefaultCursorState;

public class Cursor {
    private CursorState cursorState;
    private int lastX, lastY;

    public Cursor() {
        this.cursorState = new DefaultCursorState();
    }

    public void setCursorState(CursorState cursorState) {
        this.cursorState = cursorState;
    }

    public void mouseClicked(MouseEvent event) {
        cursorState.mouseClicked(event);
    }

    public void mousePressed(MouseEvent event) {
        lastX = event.getX();
        lastY = event.getY();
        cursorState.mousePressed(event);
    }

    public void mouseDragged(MouseEvent event) {
        int dx = event.getX() - lastX;
        int dy = event.getY() - lastY;
        lastX = event.getX();
        lastY = event.getY();
        cursorState.mouseDragged(event, dx, dy);
    }

    public void mouseReleased(MouseEvent event) {
        cursorState.mouseReleased(event);
    }
}
