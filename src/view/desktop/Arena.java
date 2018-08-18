package view.desktop;

import battlefield.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Arena extends JFrame {

    protected JPanel jPanel = new JPanel();
    protected FieldPanel playerField;


    Arena(String title) {
        super(title);
        setSize(800, 420);
        add(jPanel);
        jPanel.setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    abstract void close();
}
