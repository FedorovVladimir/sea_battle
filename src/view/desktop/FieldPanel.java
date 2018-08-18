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

    void updateField(boolean showShip) {
        for (CellButton[] row: buttonCells) {
            update(row, showShip);
        }
    }

    private void update(CellButton[] row, boolean showShip) {
        for(CellButton cellButton: row)
            if(cellButton.getCondition() == CellCondition.EMPTY)
                cellButton.setBackground(new Color(100, 150, 255));
            else if(cellButton.getCondition() == CellCondition.SHIP)
                if(showShip)
                    cellButton.setBackground(Color.GREEN);
                else
                    cellButton.setBackground(new Color(100, 150, 255));
            else if(cellButton.getCondition() == CellCondition.KILL_EMPTY)
                cellButton.setBackground(Color.WHITE);
            else if(cellButton.getCondition() == CellCondition.KILL_SHIP)
                cellButton.setBackground(Color.RED);
    }

    CellButton[][] getButtonCells() {
        return buttonCells;
    }
}
