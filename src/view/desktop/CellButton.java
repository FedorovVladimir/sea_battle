package view.desktop;

import battlefield.CellCondition;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

class CellButton extends JButton {
    private CellCondition condition;
    public int x;
    public int y;

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
