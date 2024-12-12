package org.swproject.controller.cursor.state;

import java.awt.event.MouseEvent;

public interface CursorState {
    void mouseClicked(MouseEvent event);

    void mousePressed(MouseEvent event);

    void mouseDragged(MouseEvent event, int dx, int dy);

    void mouseReleased(MouseEvent event);
}
