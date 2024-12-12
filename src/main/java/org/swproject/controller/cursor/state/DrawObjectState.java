package org.swproject.controller.cursor.state;

import java.awt.Color;
import org.swproject.model.Model;

public interface DrawObjectState {
    void createDrawCommand(Model model, Color color, int x1, int y1, int x2, int y2);
}

