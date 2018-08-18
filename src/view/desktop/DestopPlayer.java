package view.desktop;

import game.Player;
import game.View;

public class DestopPlayer extends Player {
    public DestopPlayer(String name) {
        super(name);
    }

    @Override
    public void setView() {
        view = new Desktop();
    }


}
