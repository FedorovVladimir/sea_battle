package view.desktop;

import battlefield.Cell;
import battlefield.CellCondition;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void setJustCells(Cell[][] justCells) {
        this.justCells = justCells;
    }

    public void addListner(Player player, Player he, JPanel jPanel) {
        for(int i = 0; i < buttonCells.length; i++) {
            for(int j = 0; j < buttonCells[i].length; j++) {
                buttonCells[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CellButton button = (CellButton) e.getSource();
                        if(!he.getField().shot(button.x, button.y, he.getFleet())) {
                            jPanel.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Мимо, отойдите от компьютера " +
                                    "и не подглядывайте!!!");
                            player.setStep(false);
                        }
                        else {
                            if(he.getFleet().getCountShips() == 0)
                                player.setStep(false);
                            updateField(false);
                        }

                    }
                });
            }
        }
    }

    void updateField(boolean showShip) {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if(justCells[i][j].getCondition() == CellCondition.EMPTY)
                    buttonCells[i][j].setBackground(new Color(100, 150, 255));
                else if(justCells[i][j].getCondition() == CellCondition.SHIP)
                    if(showShip)
                        buttonCells[i][j].setBackground(Color.GREEN);
                    else
                        buttonCells[i][j].setBackground(new Color(100, 150, 255));
                else if(justCells[i][j].getCondition() == CellCondition.KILL_EMPTY)
                    buttonCells[i][j].setBackground(Color.WHITE);
                else if(justCells[i][j].getCondition() == CellCondition.KILL_SHIP)
                    buttonCells[i][j].setBackground(Color.RED);
    }

    CellButton[][] getButtonCells() {
        return buttonCells;
    }

    void addListner(ArenaEditor arenaEditor, Player player, JLabel jLabel) {
        for(int i = 0; i < buttonCells.length; i++) {
            for(int j = 0; j < buttonCells[i].length; j++) {
                buttonCells[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CellButton button = (CellButton) e.getSource();
                        try {
                            player.getField().stateShipOnFlied(player.getFleet().getShip(arenaEditor.number++), button.x, button.y);
                        } catch (Exception e1) {
                            jLabel.setText("Здесь нельзя");
                            arenaEditor.number--;
                        }
                        updateField(true);
                        System.out.print(arenaEditor.number);
                        arenaEditor.updateText(player);
                    }
                });
            }
        }
    }
}
