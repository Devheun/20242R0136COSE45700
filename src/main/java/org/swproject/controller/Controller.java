package org.swproject.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.swproject.controller.cursor.Cursor;
import org.swproject.controller.cursor.state.CursorState;
import org.swproject.controller.cursor.state.DefaultCursorState;
import org.swproject.controller.cursor.state.SelectCursorState;
import org.swproject.model.CanvasObject;
import org.swproject.model.Model;
import org.swproject.observer.Observer;

public class Controller extends MouseAdapter {

    private final Model model;
    private final Cursor cursor;

    public Controller(Model model) {
        this.model = model;
        this.cursor = new Cursor();
    }

    public void createObject(CanvasObject object) {
        model.createCanvasObject(object);
    }

    public void updateObject() {
        model.updateCanvasObject();
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
}