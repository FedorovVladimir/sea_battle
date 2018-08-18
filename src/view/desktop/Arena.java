package view.desktop;

import battlefield.Cell;
import battlefield.Field;
import game.Player;

import javax.swing.*;
import java.awt.*;

class Arena extends JFrame {

    private JPanel window = new JPanel();
    private FieldPanel playerField;
    private FieldPanel heField;

    Arena(Player player, Player he) {
        super("step of " + player.getName());

        setSize(400, 810);

        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playerField = new FieldPanel(player);
        playerField.updateField(true);

        heField = new FieldPanel(he);
        heField.updateField(false);
        heField.addListner(player, he);

        window.add(playerField);
        window.add(heField);

        window.setLayout(new GridLayout(2,1));

        add(window);
    }
}
