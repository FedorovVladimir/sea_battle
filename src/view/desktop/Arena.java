package view.desktop;

import javax.swing.*;
import java.awt.*;

abstract class Arena extends JFrame {

    JPanel jPanel = new JPanel();
    FieldPanel playerField;

    Arena(String title) {
        super(title);
        setSize(850, 420);
        setLocationRelativeTo(null);
        add(jPanel);
        jPanel.setLayout(new GridLayout(1, 2));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new GridLayout(1, 2));
        add(jPanel);
    }

    abstract void close();
}
