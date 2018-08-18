package view.desktop;

import game.Player;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JFrame {

    JPanel jPanel = new JPanel();

    public Canvas(Player player, Player he) {
        super(player.getName());

        setSize(810, 400);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new GridLayout(1, 2));
        add(jPanel);
        if(player.getStep())
            setVisible(true);
    }
}
