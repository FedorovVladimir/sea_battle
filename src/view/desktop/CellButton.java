package view.desktop;

import battlefield.CellCondition;

import javax.swing.*;

class CellButton extends JButton {
    private CellCondition condition;
    private int x;
    private int y;

    CellButton(CellCondition cellCondition, int x, int y) {
        this.condition = cellCondition;
        this.x = x;
        this.y = y;
    }

    CellCondition getCondition() {
        return condition;
    }
}
