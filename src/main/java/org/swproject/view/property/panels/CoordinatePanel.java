package org.swproject.view.property.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.swproject.controller.Controller;
import org.swproject.model.CanvasObjectInterface;
import org.swproject.observer.Observer;

public class CoordinatePanel extends JPanel implements Observer {
    private final JTextField xField = new JTextField(5);
    private final JTextField yField = new JTextField(5);

    private CanvasObjectInterface canvasObject;

    public CoordinatePanel(Controller controller) {
        controller.attachObserver(this);

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel xPanel = new JPanel();
        xPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        xPanel.add(new JLabel("X Coordinate"));

        JPanel yPanel = new JPanel();
        yPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        yPanel.add(new JLabel("Y Coordinate"));

        xField.setEditable(true);
        xPanel.add(xField);

        yField.setEditable(true);
        yPanel.add(yField);

        ActionListener xListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = xField.getText();
                int xCoord = Integer.parseInt(input);

                canvasObject.move(xCoord - canvasObject.getX(), 0);

                controller.updateObject();
            }
        };
        ActionListener yListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = yField.getText();
                int yCoord = Integer.parseInt(input);

                canvasObject.move(0, yCoord - canvasObject.getY()
                );

                controller.updateObject();
            }
        };
        xField.addActionListener(xListener);
        yField.addActionListener(yListener);

        add(xPanel, BorderLayout.NORTH);
        add(yPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updateCanvasObjects(ArrayList<CanvasObjectInterface> objects) {

    }

    @Override
    public void updateSelectedCanvasObjects(CanvasObjectInterface objects) {
        this.canvasObject = objects;
        updateCoordinate(canvasObject.getX(), canvasObject.getY());
    }

    public void updateCoordinate(int x, int y) {
        xField.setText(x + "");
        yField.setText(y + "");
    }
}
