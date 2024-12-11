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

    public ColorPanel(Controller controller) {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JLabel("Color"));
        add(colorButton);

        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Choose a Color", Color.WHITE);
            if (color != null) {
                controller.setColor(color);
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
