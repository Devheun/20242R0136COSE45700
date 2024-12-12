package org.swproject.controller.cursor.state;

import java.awt.Color;
import org.swproject.command.CommandInvoker;
import org.swproject.command.DrawEllipseCommand;
import org.swproject.command.DrawLineCommand;
import org.swproject.command.DrawRectangleCommand;
import org.swproject.model.Model;

public enum DrawObjectStateEnum implements DrawObjectState {
    DRAW_RECTANGLE {
        @Override
        public void createDrawCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
            DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(model, color, x1, y1, x2, y2);
            CommandInvoker.getInstance().executeCommand(drawRectangleCommand);
        }
    },

    DRAW_ELLIPSE {
        @Override
        public void createDrawCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
            DrawEllipseCommand drawEllipseCommand = new DrawEllipseCommand(model, color, x1, y1, x2, y2);
            CommandInvoker.getInstance().executeCommand(drawEllipseCommand);
        }
    },

    DRAW_LINE {
        @Override
        public void createDrawCommand(Model model, Color color, int x1, int y1, int x2, int y2) {
            DrawLineCommand drawLineCommand = new DrawLineCommand(model, color, x1, y1, x2, y2);
            CommandInvoker.getInstance().executeCommand(drawLineCommand);
        }
    }
}
