package battlefield;

public class Cell {

    private CellCondition condition = CellCondition.EMPTY;

    boolean shot() {
        boolean isGoodShot = false;
        if(condition == CellCondition.EMPTY)
            condition = CellCondition.KILL_EMPTY;
        if(condition == CellCondition.SHIP) {
            condition = CellCondition.KILL_SHIP;
            isGoodShot = true;
        }
        return isGoodShot;
    }

    void die() {
        if(condition == CellCondition.EMPTY)
            condition = CellCondition.KILL_EMPTY;
    }

    void doShip() {
        condition = CellCondition.SHIP;
    }

    boolean isEmpty() {
        return condition == CellCondition.EMPTY;
    }

    public CellCondition getCondition() {
        return condition;
    }
}
