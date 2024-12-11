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

    private final static int defaultCoordinate = 100;
    private final static Color defaultColor = Color.BLACK;

    public EditorMenu(Controller controller) {
        JMenu shapeMenu = new JMenu("Add shape");

        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(event -> controller.createObject(new RectangleObject(
                defaultColor, defaultCoordinate, defaultCoordinate, defaultCoordinate + 100, defaultCoordinate + 100
        )));

        JMenuItem ellipseItem = new JMenuItem("Ellipse");
        ellipseItem.addActionListener(
                e -> controller.createObject(
                        new EllipseObject(defaultColor, defaultCoordinate,
                                defaultCoordinate, defaultCoordinate + 100, defaultCoordinate + 100)));

        JMenuItem lineItem = new JMenuItem("Line");
        lineItem.addActionListener(
                e -> controller.createObject(
                        new LineObject(defaultColor, defaultCoordinate, defaultCoordinate,
                                defaultCoordinate + 100,
                                defaultCoordinate + 100)));

        shapeMenu.add(rectangleItem);
        shapeMenu.add(ellipseItem);
        shapeMenu.add(lineItem);
        add(shapeMenu);

        JMenu cursorMode = new JMenu("Cursor Mode");
        JMenuItem defaultModeItem = new JMenuItem("Default Mode");
        defaultModeItem.addActionListener(event -> controller.setDefaultCursorState());

        JMenuItem selectModeItem = new JMenuItem("Select Mode");
        selectModeItem.addActionListener(event -> controller.setSelectCursorState());

        cursorMode.add(defaultModeItem);
        cursorMode.add(selectModeItem);
        add(cursorMode);

        JMenu changeMode = new JMenu("Change Order");
        JMenuItem frontOrderItem = new JMenuItem("Place to Front");
        frontOrderItem.addActionListener(e -> controller.placeObjectToFront());

        JMenuItem backOrderItem = new JMenuItem("Place to Back");
        backOrderItem.addActionListener(e -> controller.placeObjectToBack());
        changeMode.add(frontOrderItem);
        changeMode.add(backOrderItem);
        add(changeMode);
    }
}
