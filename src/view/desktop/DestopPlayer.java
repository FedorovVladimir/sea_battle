package view.desktop;

import game.Player;

public class DestopPlayer extends Player {
    public DestopPlayer(String name) {
        super(name);
    }

    @Override
    public void setView() {
        view = new Desktop();
    }
}
