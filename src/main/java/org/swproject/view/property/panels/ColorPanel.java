package org.swproject.view.property.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.observer.Observer;

public class ColorPanel extends JPanel implements Observer {

    private final JButton colorButton = new JButton("Choose Color");
    private CanvasObjectInterface canvasObject;
    private final Controller controller;
    private Color savedColor;

    public ColorPanel(Controller controller) {
        this.controller = controller;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JLabel("Color"));
        add(colorButton);

        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Choose a Color", Color.WHITE);
            if (color != null) {
                if (canvasObject != null) {
                    canvasObject.setColor(color);
                    this.repaint();
                    controller.updateObject();
                } else {
                    System.out.println("Error: canvasObject is null");
                }
            }
        });

    }

    public void setCanvasObject(CanvasObjectInterface canvasObject) {
        this.canvasObject = canvasObject;
    }

    @Override
    public void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects) {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        this.canvasObject = objects;

    }
}
