package view.console;

import game.Player;

public class ConsolePlayer extends Player {

    public ConsolePlayer(String name) {
        super(name);
    }

    @Override
    public void setView() {
        view = new Console();
    }
}
