package org.swproject.view.menu;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.swproject.controller.Controller;
import org.swproject.model.object.EllipseObject;
import org.swproject.model.object.LineObject;
import org.swproject.model.object.RectangleObject;

public class EditorMenu extends JMenuBar {

    private final static int defaultCoordinate = 30;
    private final static int defaultSize = 50;
    private final static Color defaultColor = Color.GREEN;

    public EditorMenu(Controller controller) {
        JMenu shapeMenu = new JMenu("Add shape");

        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(event -> controller.createObject(new RectangleObject(
                defaultColor, defaultSize, defaultSize, defaultCoordinate, defaultCoordinate
        )));

        JMenuItem ellipseItem = new JMenuItem("Ellipse");
        ellipseItem.addActionListener(
                e -> controller.createObject(
                        new EllipseObject(defaultColor, defaultSize, defaultSize, defaultCoordinate,
                                defaultCoordinate)));

        JMenuItem lineItem = new JMenuItem("Line");
        lineItem.addActionListener(
                e -> controller.createObject(
                        new LineObject(defaultColor, defaultCoordinate, defaultCoordinate, defaultSize, defaultSize,
                                defaultCoordinate + 20,
                                defaultCoordinate + 20)));

        shapeMenu.add(rectangleItem);
        shapeMenu.add(ellipseItem);
        shapeMenu.add(lineItem);
        add(shapeMenu);
    }
}
