package view.desktop;

import battlefield.Cell;
import battlefield.CellCondition;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArenaEditor extends JFrame {
    private JPanel jPanel = new JPanel();
    private FieldPanel fieldPanel;
    private JPanel editor = new JPanel();

    private JButton setShips = new JButton("Закончить расстановку");

    ArenaEditor(Player player) {
        super("Расставьте корабли, " + player.getName());
        setSize(800, 420);
        add(jPanel);
        jPanel.setLayout(new GridLayout(1, 2));

        fieldPanel = new FieldPanel(player);
        fieldPanel.updateField(true);
        jPanel.add(fieldPanel);

        setShips.setVisible(true);
        editor.add(setShips);

        setShips.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        jPanel.add(editor);
    }

    private void close() {
        setVisible(false);
    }
}
