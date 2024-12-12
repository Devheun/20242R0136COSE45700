package org.swproject.view.property.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.observer.Observer;

public class HeightPanel extends JPanel implements Observer {

    private final JTextField heightField = new JTextField(10);

    public HeightPanel(Controller controller) {
        controller.attachObserver(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JLabel("Height"));
        heightField.setEditable(true);

        ActionListener heightListener = e -> {
            int height = Integer.parseInt(heightField.getText());
            controller.setHeight(height);
        };
        heightField.addActionListener(heightListener);
        add(heightField);
    }

    @Override
    public void updateCanvasObjects() {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        updateHeight(objects.getHeight());
    }

    public void updateHeight(int height) {
        heightField.setText(height + "");
    }

}
