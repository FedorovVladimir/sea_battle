package view.desktop;

import battlefield.Cell;
import battlefield.CellCondition;
import battlefield.Field;
import game.Player;

import javax.swing.*;
import java.awt.*;

class FieldPanel extends JPanel {
    private CellButton[][] buttonCells;
    private Cell[][] justCells;

    FieldPanel(Player player) {
        super();
        this.setLayout(new GridLayout(10, 10));
        this.setMaximumSize(new Dimension(400, 400));

        justCells = player.getField().getMatrix();

        buttonCells = new CellButton[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                buttonCells[i][j] = new CellButton(justCells[i][j].getCondition(), i, j);
                this.add(buttonCells[i][j]);
            }
        }
    }

    void updateField() {
        for (CellButton[] row: buttonCells) {
            update(row);
        }
    }

    private void update(CellButton[] row) {
        for(CellButton cellButton: row)
            if(cellButton.getCondition() == CellCondition.EMPTY)
                cellButton.setBackground(Color.BLUE);
            else if(cellButton.getCondition() == CellCondition.SHIP)
                cellButton.setBackground(Color.GREEN);
            else if(cellButton.getCondition() == CellCondition.KILL_EMPTY)
                cellButton.setBackground(Color.WHITE);
            else if(cellButton.getCondition() == CellCondition.KILL_SHIP)
                cellButton.setBackground(Color.RED);
    }

    private void updateHe(CellButton[] row) {
        for(CellButton cellButton: row)
            if(cellButton.getCondition() == CellCondition.EMPTY)
                cellButton.setBackground(Color.BLUE);
            else if(cellButton.getCondition() == CellCondition.SHIP)
                cellButton.setBackground(Color.BLUE);
            else if(cellButton.getCondition() == CellCondition.KILL_EMPTY)
                cellButton.setBackground(Color.WHITE);
            else if(cellButton.getCondition() == CellCondition.KILL_SHIP)
                cellButton.setBackground(Color.RED);
    }

    CellButton[][] getButtonCells() {
        return buttonCells;
    }
}
