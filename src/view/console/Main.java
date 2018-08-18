package view.console;

import game.Player;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new ConsolePlayer(JOptionPane.showInputDialog("Введите своё имя"));
        firstPlayer.putFleet();
        firstPlayer.setStep(true);

        Player secondPlayer = new ConsolePlayer(JOptionPane.showInputDialog("Введите своё имя"));
        secondPlayer.putFleet();

        while (!firstPlayer.isWin() && !secondPlayer.isWin())
            if(firstPlayer.getStep()) {
                firstPlayer.step(secondPlayer);
                secondPlayer.setStep(!firstPlayer.getStep());
            }
            else {
                secondPlayer.step(firstPlayer);
                firstPlayer.setStep(!secondPlayer.getStep());
            }

        if(firstPlayer.isWin()) {
            firstPlayer.win();
            secondPlayer.lose();
        } else {
            firstPlayer.lose();
            secondPlayer.win();
        }
    }
}
