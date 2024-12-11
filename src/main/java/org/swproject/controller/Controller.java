package org.swproject.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import org.swproject.command.CommandInvoker;
import org.swproject.command.MoveCommand;
import org.swproject.command.SetColorCommand;
import org.swproject.command.SetHeightCommand;
import org.swproject.command.SetWidthCommand;
import org.swproject.controller.cursor.Cursor;
import org.swproject.controller.cursor.state.CursorState;
import org.swproject.controller.cursor.state.DefaultCursorState;
import org.swproject.controller.cursor.state.DrawObjectStateEnum;
import org.swproject.controller.cursor.state.SelectCursorState;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.Model;
import org.swproject.observer.Observer;

public class Controller extends MouseAdapter {

    private final Model model;
    private final Cursor cursor;

    public Controller(Model model) {
        this.model = model;
        this.cursor = new Cursor();
    }

    // 도형 그리기
    public void drawObject(DrawObjectStateEnum drawState, Color color, int x1, int y1, int x2, int y2) {
        drawState.createDrawCommand(model, color, x1, y1, x2, y2);
    }

    public void attachObserver(Observer o) {
        model.attachObserver(o);
    }

    public void setCursor(CursorState state) {
        this.cursor.setCursorState(state);
    }

    public void setDefaultCursorState() {
        setCursor(new DefaultCursorState());
    }

    public void setSelectCursorState() {
        setCursor(new SelectCursorState(model));
    }

    public void placeObjectToFront() {
        model.placeObjectToFront();
    }

    public void placeObjectToBack() {
        model.placeObjectToBack();
    }

    public void move(int dx, int dy) {
        MoveCommand moveCommand = new MoveCommand(model, dx, dy);
        CommandInvoker.getInstance().executeCommand(moveCommand);
    }

    public void setWidth(int width) {
        SetWidthCommand setWidthCommand = new SetWidthCommand(model, width);
        CommandInvoker.getInstance().executeCommand(setWidthCommand);
    }

    public void setHeight(int height) {
        SetHeightCommand setHeightCommand = new SetHeightCommand(model, height);
        CommandInvoker.getInstance().executeCommand(setHeightCommand);
    }

    public void setColor(Color color) {
        SetColorCommand setColorCommand = new SetColorCommand(model, color);
        CommandInvoker.getInstance().executeCommand(setColorCommand);
    }

    public void undo() {
        CommandInvoker.getInstance().undo();
    }

    public void redo() {
        CommandInvoker.getInstance().redo();
    }

    public CanvasObjectInterface getSelectedCanvasObjects() {
        return model.getCanvasObjectComposite();
    }

    public List<CanvasObjectInterface> getCanvasObjects() {
        return model.getCanvasObjects();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.cursor.mouseClicked(event);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.cursor.mousePressed(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        this.cursor.mouseDragged(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        this.cursor.mouseReleased(event);
    }
}