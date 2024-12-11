package org.swproject.view.property;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.observer.Observer;
import org.swproject.view.property.panels.ColorPanel;
import org.swproject.view.property.panels.CoordinatePanel;
import org.swproject.view.property.panels.HeightPanel;
import org.swproject.view.property.panels.WidthPanel;

public class PropertyPanel extends JPanel implements Observer {

    private CanvasObjectInterface canvasObject;
    private final Controller controller;
    private final WidthPanel widthPanel;
    private final HeightPanel heightPanel;
    private final CoordinatePanel coordinatePanel;
    private final ColorPanel colorPanel;

    public PropertyPanel(Controller controller) {
        this.controller = controller;
        this.controller.attachObserver(this);

        this.heightPanel = new HeightPanel(controller);
        this.widthPanel = new WidthPanel(controller);
        this.coordinatePanel = new CoordinatePanel(controller);
        this.colorPanel = new ColorPanel(controller);
        setPreferredSize(new Dimension(200, getHeight()));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        add(heightPanel);
        add(widthPanel);
        add(coordinatePanel);
        add(colorPanel);

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> controller.undo());
        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(e -> controller.redo());
        add(undoButton);
        add(redoButton);
    }

    @Override
    public void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects) {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        this.canvasObject = objects;
        heightPanel.updateHeight(canvasObject.getHeight());

        widthPanel.updateWidth(canvasObject.getWidth());

        coordinatePanel.updateCoordinate(canvasObject.getX(), canvasObject.getY());
        colorPanel.setCanvasObject(canvasObject);
    }

    public void updateCanvasObject(int x, int y, int width, int height) {
//        canvasObject.resize(x, y);
        this.controller.updateObject();
    }
}
