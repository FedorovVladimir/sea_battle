package battlefield;

public class Ship {

    private int x;
    private int y;
    private int length;
    private ShipOrientation orientation = ShipOrientation.HORIZONTALLY;
    private ShipCondition condition = ShipCondition.LIVE;

    Ship(int length) {
        this.length = length;
    }

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void schangeOrientation() {
        if(orientation == ShipOrientation.HORIZONTALLY)
            orientation = ShipOrientation.VERTICAL;
        else
            orientation = ShipOrientation.HORIZONTALLY;
    }

    boolean live(ButtleField buttleField) {
        if(condition == ShipCondition.DIE)
            return false;
        boolean isLive = false;
        int x = this.x;
        int y = this.y;
        for (int i = 0; i < length; i++) {
            if(buttleField.getCondition(x, y) == CellCondition.SHIP)
                isLive = true;
            if (orientation == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
        if(!isLive)
            die(buttleField);

        return isLive;
    }

    private void die(ButtleField buttleField) {
        condition = ShipCondition.DIE;
        for (int i = 0; i < length; i++) {
            buttleField.die(x, y);
            if (orientation == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
    }

    int getLength() {
        return length;
    }

    ShipOrientation getOrientation() {
        return orientation;
    }
}
