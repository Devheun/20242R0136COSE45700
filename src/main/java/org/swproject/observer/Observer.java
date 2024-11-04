package org.swproject.observer;

import java.util.ArrayList;
import org.swproject.model.CanvasObjectInterface;

public interface Observer {
    void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects);

    void updateSelectedCanvasObjects(CanvasObjectInterface objects);
}
