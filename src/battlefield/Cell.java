package battlefield;

public class Cell {

    private CellCondition condition = CellCondition.EMPTY;

    public CellCondition getCondition() {
        return condition;
    }

    void doShip() {
        condition = CellCondition.SHIP;
    }

    boolean shot() {
        if(condition == CellCondition.EMPTY)
            condition = CellCondition.KILL_EMPTY;
        if(condition == CellCondition.SHIP) {
            condition = CellCondition.KILL_SHIP;
            return true;
        }
        return false;
    }

    void die() {
        if(condition == CellCondition.EMPTY)
            condition = CellCondition.KILL_EMPTY;
    }
}
