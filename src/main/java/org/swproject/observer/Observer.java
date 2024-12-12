package org.swproject.observer;

import org.swproject.model.CanvasObjectInterface;

public interface Observer {
    void updateCanvasObjects();

    void updateSelectedCanvasObjects(CanvasObjectInterface objects);
}
