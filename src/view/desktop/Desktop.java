package view.desktop;

import game.Player;
import game.View;

import javax.swing.*;

public class Desktop implements View {
    private ArenaEditor arenaEditor;
    private ArenaRing arena;

    public ArenaRing getArena() {
        return arena;
    }

    @Override
    public void putFleet(Player player) {
        if(arenaEditor == null)
            arenaEditor = new ArenaEditor("Расстановка кораблей " + player.getName(), player);
        arenaEditor.setVisible(true);

        while (arenaEditor.isVisible())
            System.out.print("");

        arenaEditor = null;
    }

    @Override
    public void step(Player player, Player he) {
        if(arena == null)
            arena = new ArenaRing(player, he);

        arena.update();
        arena.setJPanelVisible();
        arena.setVisible(true);

        while(player.getStep()) {
            System.out.println("");
        }

        if(he.getFleet().getCountShips() == 0)
            player.setWin(true);

        if (!player.getStep()) {
            arena.setVisible(false);
        }
    }

    @Override
    public void win(String name) {
        JOptionPane.showMessageDialog(null,name + ", вы победили");
        arena.dispose();
    }

    @Override
    public void lose() {
        JOptionPane.showMessageDialog(null,"Семь раз отмерь, один раз отрежь");
        arena.dispose();
    }
}
