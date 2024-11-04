package org.swproject.view.property.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.observer.Observer;

public class HeightPanel extends JPanel implements Observer {

    private final JTextField heightField = new JTextField(10);
    private CanvasObjectInterface canvasObject;

    public HeightPanel(Controller controller) {
        controller.attachObserver(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JLabel("Height"));
        heightField.setEditable(true);

        ActionListener heightListener = e -> {
            String input = heightField.getText();
            int height = Integer.parseInt(input);
            canvasObject.resize(canvasObject.getX(), canvasObject.getY(),
                    canvasObject.getWidth(), height);
            controller.updateObject();
        };
        heightField.addActionListener(heightListener);
        add(heightField);
    }

    @Override
    public void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects) {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        this.canvasObject = objects;
        updateHeight(canvasObject.getHeight());
    }

    public void updateHeight(int height) {
        heightField.setText(height + "");
    }

}
