package org.swproject.controller.cursor;

import java.awt.event.MouseEvent;
import org.swproject.controller.cursor.state.CursorState;
import org.swproject.controller.cursor.state.DefaultCursorState;

public class Cursor {
    private CursorState cursorState;

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
        cursorState.mousePressed(event);
    }

    public void mouseDragged(MouseEvent event) {
        cursorState.mouseDragged(event);
    }
}
