package view.desktop;

import battlefield.Cell;
import battlefield.Field;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ArenaRing extends Arena {

    private FieldPanel heField;

    ArenaRing(Player player, Player he) {
        super("Борется " + player.getName());


        playerField = new FieldPanel(player);
        playerField.updateField(true);

        heField = new FieldPanel(he);
        heField.updateField(false);

        jPanel.add(playerField);
        jPanel.add(heField);
    }

    @Override
    void close() {

    }
}
