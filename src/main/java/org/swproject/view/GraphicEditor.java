package org.swproject.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.swproject.view.menu.EditorMenu;

public class GraphicEditor extends JFrame {
    private static final int EDITOR_WIDTH = 800;
    private static final int EDITOR_HEIGHT = 600;

    public GraphicEditor() {
        setTitle("Canvas");
        setSize(EDITOR_WIDTH, EDITOR_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new EditorMenu(), BorderLayout.BEFORE_FIRST_LINE);
    }
}
