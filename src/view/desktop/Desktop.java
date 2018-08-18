package view.desktop;

import game.Player;
import game.View;

import javax.swing.*;

public class Desktop implements View {
    @Override
    public void putFleet(Player player) {

    }

    @Override
    public void step(Player player, Player he) {
        Canvas canvas = new Canvas(player, he);

        //JOptionPane.showMessageDialog(null, "hi");

        //canvas.setVisible(false);
    }

    @Override
    public void win(String name) {
        JOptionPane.showMessageDialog(null,name + ", вы победили");
    }

    @Override
    public void lose() {
        JOptionPane.showMessageDialog(null,"Вы проиграли");
    }
}
