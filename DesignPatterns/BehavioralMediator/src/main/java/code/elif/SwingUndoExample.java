package code.elif;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class SwingUndoExample {
    public static void main(String[] argv) {

        JTextComponent textbook = new JTextArea();
        final UndoManager undo = new UndoManager();
        Document doc = textbook.getDocument();

        doc.addUndoableEditListener(undo);

        textbook.getActionMap().put("Undo", new AbstractAction("Undo") {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canUndo()) {
                        undo.undo();
                    }
                } catch (CannotUndoException e) {
                }
            }
        });

        textbook.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(textbook));
        frame.setSize(380, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
