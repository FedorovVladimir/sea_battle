package view.desktop;

import game.Player;

class ArenaRing extends Arena {


    private FieldPanel heField;

    ArenaRing(Player player, Player he) {
        super("Борется " + player.getName());


        playerField = new FieldPanel(player);
        playerField.updateField(true);

        heField = new FieldPanel(he);
        heField.updateField(false);
        heField.addListner(player, he);

        jPanel.add(playerField);
        jPanel.add(heField);


    }

    public void update() {
        playerField.updateField(true);
        heField.updateField(false);
    }

    @Override
    void close() {

    }

}

