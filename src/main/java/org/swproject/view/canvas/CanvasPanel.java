package org.swproject.view.canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.model.decorator.SelectedCanvasObjectDecorator;
import org.swproject.observer.Observer;

public class CanvasPanel extends JPanel implements Observer {
    private final Controller controller;

    public CanvasPanel(Controller controller) {
        this.controller = controller;
        controller.attachObserver(this);
        setBackground(Color.WHITE);
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        for (CanvasObjectInterface object : controller.getCanvasObjects()) {
            object.draw(graphics2D);
        }

        CanvasObjectInterface selectedCanvasObjects = controller.getSelectedCanvasObjects();

        if (selectedCanvasObjects != null) {
            SelectedCanvasObjectDecorator selectedCanvasObjectDecorator = new SelectedCanvasObjectDecorator(
                    selectedCanvasObjects);
            selectedCanvasObjectDecorator.draw(graphics2D);
        }
    }

    @Override
    public void updateCanvasObjects() {
        repaint();
    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        repaint();
    }

}
