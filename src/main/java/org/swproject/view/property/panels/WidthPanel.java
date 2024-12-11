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

public class WidthPanel extends JPanel implements Observer {
    private final JTextField widthField = new JTextField(10);
    private CanvasObjectInterface canvasObject;

    public WidthPanel(Controller controller) {
        controller.attachObserver(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JLabel("Width"));
        widthField.setEditable(true);

        ActionListener widthListener = e -> {
            int width = Integer.parseInt(widthField.getText());
            controller.setWidth(width);
        };
        widthField.addActionListener(widthListener);
        add(widthField);
    }

    @Override
    public void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects) {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        this.canvasObject = objects;
        updateWidth(canvasObject.getWidth());
    }

    public void updateWidth(int width) {
        widthField.setText(width + "");
    }
}
