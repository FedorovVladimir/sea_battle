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

    boolean live(Field field) {
        if(condition == ShipCondition.DIE)
            return false;
        boolean isLive = false;
        int x = this.x;
        int y = this.y;
        for (int i = 0; i < length; i++) {
            if(field.getMatrix()[x][y].getCondition() == CellCondition.SHIP)
                isLive = true;
            if (orientation == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
        if(!isLive)
            die(field);

        return isLive;
    }

    private void die(Field field) {
        condition = ShipCondition.DIE;
        for (int i = 0; i < length; i++) {
            field.die(x, y);
            if (orientation == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public ShipOrientation getOrientation() {
        return orientation;
    }

    public ShipCondition getCondition() {
        return condition;
    }

}
