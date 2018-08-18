package view.desktop;

import game.Player;
import game.View;

import javax.swing.*;

public class Desktop implements View {
    private ArenaEditor arenaEditor;
    private Arena arena;

    @Override
    public void putFleet(Player player) {
        if(arenaEditor == null)
            arenaEditor = new ArenaEditor(player);

        arenaEditor.setVisible(true);


        while (arenaEditor.isVisible())
            System.out.println(player.getName());
        player.setStep(false);
        arenaEditor = null;
    }

    @Override
    public void step(Player player, Player he) {
        if(arena == null)
            arena = new Arena(player, he);

        arena.setVisible(true);


        while (arena.isVisible())
            System.out.println(player.getName());
        player.setStep(false);



        if (!player.getStep()) {
            arena.setVisible(true);
        }
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
