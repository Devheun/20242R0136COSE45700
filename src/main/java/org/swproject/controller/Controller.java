package org.swproject.controller;

import org.swproject.model.CanvasObject;
import org.swproject.model.Model;
import org.swproject.observer.Observer;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void createObject(CanvasObject object) {
        model.createCanvasObject(object);
    }

    public void updateObject(CanvasObject object) {
        model.updateCanvasObject(object);
    }

    public void attachObserver(Observer o) {
        model.attachObserver(o);
    }
}