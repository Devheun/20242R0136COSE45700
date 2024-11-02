package org.swproject.view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditorMenu extends JMenuBar {

    public EditorMenu() {
        JMenu shapeMenu = new JMenu("Add shape");

        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        JMenuItem ellipseItem = new JMenuItem("Ellipse");

        shapeMenu.add(rectangleItem);
        shapeMenu.add(ellipseItem);
        add(shapeMenu);
    }
}
