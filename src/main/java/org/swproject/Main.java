package org.swproject;

import javax.swing.SwingUtilities;
import org.swproject.controller.Controller;
import org.swproject.model.Model;
import org.swproject.view.GraphicEditor;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        SwingUtilities.invokeLater(() -> {
            GraphicEditor editor = new GraphicEditor(controller);
            editor.setVisible(true);
        });
    }
}
