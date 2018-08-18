package view.desktop;

import game.Player;

import javax.swing.*;

public class Arena extends JFrame {

    public Arena(Player player, Player he) {
        super("step of " + player.getName());

        setSize(600, 600);

    }
}
