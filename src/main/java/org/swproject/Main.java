package main.java.org.swproject;

import javax.swing.SwingUtilities;
import main.java.org.swproject.view.GraphicEditor;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphicEditor editor = new GraphicEditor();
            editor.setVisible(true);
        });
    }
}
