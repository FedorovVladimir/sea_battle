package view.desktop;


import battlefield.ShipOrientation;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArenaEditor extends Arena{

    private JPanel editor = new JPanel();
    private JButton send = new JButton("Закончить расстановку");
    private JLabel text = new JLabel();
    private JButton change = new JButton("Сменить ориентацию корабля");

    Integer number = 0;

    ArenaEditor(String title, Player player) {
        super(title);
        playerField = new FieldPanel(player);
        playerField.updateField(true);
        playerField.addListner(this, player, text);
        jPanel.add(playerField);

        playerField.setVisible(true);

        editor.setBackground(Color.WHITE);
        editor.setVisible(true);
        editor.setLayout(new GridLayout(3, 1));
        jPanel.add(editor);

        updateText(player);
        editor.add(text);

        change.setVisible(true);
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.getFleet().getShip(number).schangeOrientation();
                updateText(player);
            }
        });
        editor.add(change);

        send.setVisible(true);
        send.setEnabled(false);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        editor.add(send);
    }

    void updateText(Player player) {
        if(number < 10) {
            String textShip = "Ставим корабль длинны " +
                    player.getFleet().getShip(number).getLength();
            if (player.getFleet().getShip(number).getOrientation() == ShipOrientation.HORIZONTALLY)
                textShip += " (вертикильно)";
            else
                textShip += " (горизонтально)";

            text.setText(textShip);
        } else {
            text.setText("Все корабли расставлены");
            change.setEnabled(false);
            send.setEnabled(true);
        }
    }

    @Override
    void close() {
        setVisible(false);
    }
}
