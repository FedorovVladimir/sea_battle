package view.desktop;

import battlefield.Cell;
import battlefield.CellCondition;
import game.Player;

import javax.swing.*;
import java.awt.*;

class ArenaEditor extends JFrame {

    private JPanel jPanel = new JPanel();

    ArenaEditor(Player player) {
        super("Расставьте корабли, " + player.getName());
        setSize(600, 600);
        add(jPanel);

        jPanel.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                CellButton cellButton = new CellButton(CellCondition.EMPTY, i, j);
                cellButton.setText(i + " " + j);
                cellButton.setVisible(true);
                jPanel.add(cellButton);
            }
    }
}
