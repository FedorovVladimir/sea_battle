package view.desktop;

import battlefield.Cell;
import battlefield.CellCondition;
import game.Player;

import javax.swing.*;
import java.awt.*;

class ArenaEditor extends JFrame {

    private FieldPanel fieldPanel;

    ArenaEditor(Player player) {
        super("Расставьте корабли, " + player.getName());
        setSize(600, 600);

        fieldPanel = new FieldPanel(player);
        fieldPanel.updateField(true);
        add(fieldPanel);
    }
}
