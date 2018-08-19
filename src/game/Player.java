package game;

import battlefield.ButtleField;

public abstract class Player {
    private String name;
    private ButtleField buttleField = new ButtleField();
    private boolean isWin = false;
    private boolean isStep = false;
    private View view;

    public Player(String name) {
        this.name = name;
        setView();
    }

    public void shot(Player player) {

    }

    public void stepOn(Player opponent) {
        view.step(this, opponent);
    }

    public void win() {
        view.win(name);
    }

    public void lose() {
        view.lose();
    }



    protected abstract void setView();
    
    public String getName() {
        return name;
    }

    public void putFleet() {
        view.putFleet(this);
    }

    public ButtleField getButtleField() {
        return buttleField;
    }

    public boolean isWin() {
        return isWin;
    }

    public Boolean getStep() {
        return isStep;
    }

    public void setStep(Boolean step) {
        isStep = step;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getCountShips() {
        return buttleField.getCountShips();
    }
}
