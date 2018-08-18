package game;

import battlefield.Field;
import battlefield.Fleet;
import view.console.Console;

public abstract class Player {
    String name;
    private Field field = new Field();
    private Fleet fleet = new Fleet();
    private boolean isWin = false;
    private Boolean isStep = false;
    protected View view;

    public Player(String name) {
        this.name = name;
        setView();
    }

    public String getName() {
        return name;
    }

    public abstract void setView();

    public void putFleet() {
        view.putFleet(this);
    }

    public void step(Player he) {
        view.step(this, he);
    }

    public void win() {
        view.win(name);
    }

    public void lose() {
        view.lose();
    }

    public Field getField() {
        return field;
    }

    public Fleet getFleet() {
        return fleet;
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
}
