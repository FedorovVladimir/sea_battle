package view.desktop;

import battlefield.Cell;
import game.Player;

import javax.swing.*;
import java.awt.*;

public class Arena extends JFrame {

    private JPanel window = new JPanel();
    private JPanel playerField;
    private JPanel heField;

    public Arena(Player player, Player he) {
        super("step of " + player.getName());

        setSize(400, 810);

        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playerField = initPlayerField(player);
//        heField = initHeField(he);
        window.add(playerField);

        window.setLayout(new GridLayout(2,1));

        add(window);

    }

    public JPanel initPlayerField(Player player) {
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(10, 10));
        field.setMaximumSize(new Dimension(400, 400));

        Cell[][] justCells = player.getField().getMatrix();

        CellButton[][] buttonCells = new CellButton[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                buttonCells[i][j] = new CellButton(justCells[i][j].getCondition(), i, j);
                field.add(buttonCells[i][j]);
            }
        }
        return field;
    }

    public void updateWindow(Player player, Player he) {
        window.
    }
}
