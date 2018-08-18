package view.desktop;

import battlefield.CellCondition;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

class CellButton extends JButton {
    private CellCondition condition;
    int x;
    int y;

    CellButton(CellCondition cellCondition, int x, int y) {
        this.condition = cellCondition;
        this.x = x;
        this.y = y;

        setBorder(new LineBorder(Color.darkGray, 1));
    }

    CellCondition getCondition() {
        return condition;
    }
}
