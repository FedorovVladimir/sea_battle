package view.desktop;

import battlefield.Cell;
import game.Player;

import javax.swing.*;
import java.awt.*;

class Arena extends JFrame {

    private JPanel window = new JPanel();
    private FieldPanel playerField;
    private JPanel heField;

    Arena(Player player, Player he) {
        super("step of " + player.getName());

        setSize(400, 810);

        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playerField = new FieldPanel(player);
        playerField.updateField();
        playerField.getButtonCells()[1][1].setBackground(Color.RED);
        window.add(playerField);

        window.setLayout(new GridLayout(2,1));

        add(window);

    }
}
