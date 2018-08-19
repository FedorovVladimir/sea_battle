package battlefield;

public class ButtleField {

    private int size = 10;
    private Cell[][] matrix = new Cell[size][size];
    private int countShips = 10;
    private Ship[] ships = new Ship[countShips];

    public ButtleField() {
        for (int i = 0; i < size; i++) {
            matrix[i] = new Cell[size];
            for (int j = 0; j < size; j++)
                matrix[i][j] = new Cell();
        }

        ships[0] = new Ship(4);
        ships[1] = new Ship(3);
        ships[2] = new Ship(3);
        ships[3] = new Ship(2);
        ships[4] = new Ship(2);
        ships[5] = new Ship(2);
        ships[6] = new Ship(1);
        ships[7] = new Ship(1);
        ships[8] = new Ship(1);
        ships[9] = new Ship(1);
    }

    public boolean stateShipOnFlied(Ship ship, int x, int y) {
        boolean isState = false;
        if(isSecurityPosition(ship, x, y)) {
            stateShip(ship, x, y);
            isState = true;
        }
        return isState;
    }

    private boolean isSecurityPosition(Ship ship, int x, int y) {
        for (int i = 0; i < ship.getLength(); i++) {
            if(!isSecurityPosition(x, y))
                return false;
            if(ship.getOrientation() == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
        return true;
    }

    private void stateShip(Ship ship, int x, int y) {
        if(isSecurityPosition(ship, x, y)) {
            state(ship, x, y);
        }
    }

    private boolean isSecurityPosition(int x, int y) {
        boolean isSecurityPosition = matrix[x][y].isEmpty();
        if(x > 0)
            isSecurityPosition = isSecurityPosition && matrix[x - 1][y].isEmpty();
        if(x < 9)
            isSecurityPosition = isSecurityPosition && matrix[x + 1][y].isEmpty();
        if(y > 0)
            isSecurityPosition = isSecurityPosition && matrix[x][y - 1].isEmpty();
        if(y < 9)
            isSecurityPosition = isSecurityPosition && matrix[x][y + 1].isEmpty();
        if(x > 0 && y > 0)
            isSecurityPosition = isSecurityPosition && matrix[x - 1][y - 1].isEmpty();
        if(x > 0 && y < 9)
            isSecurityPosition = isSecurityPosition && matrix[x - 1][y + 1].isEmpty();
        if(x < 9 && y < 9)
            isSecurityPosition = isSecurityPosition && matrix[x + 1][y + 1].isEmpty();
        if(x < 9 && y > 0)
            isSecurityPosition = isSecurityPosition && matrix[x + 1][y - 1].isEmpty();
        return isSecurityPosition;
    }

    private void state(Ship ship, int x, int y) {
        ship.setPosition(x, y);
        for (int i = 0; i < ship.getLength(); i++) {
            matrix[x][y].doShip();
            if(ship.getOrientation() == ShipOrientation.HORIZONTALLY)
                x++;
            else
                y++;
        }
    }

    public boolean shot(int x, int y) {
        boolean isKill =  matrix[x][y].shot();
        if(isKill)
            calcCountShips();
        return isKill;
    }

    private void calcCountShips() {
        countShips = 0;
        for (Ship ship: ships) {
            if(ship.live(this))
                countShips++;
        }
    }

    void die(int x, int y) {
        if(x > 0)
            matrix[x - 1][y].die();
        if(x < 9)
            matrix[x + 1][y].die();
        if(y > 0)
            matrix[x][y - 1].die();
        if(y < 9)
            matrix[x][y + 1].die();
        if(x > 0 && y > 0)
            matrix[x - 1][y - 1].die();
        if(x > 0 && y < 9)
            matrix[x - 1][y + 1].die();
        if(x < 9 && y < 9)
            matrix[x + 1][y + 1].die();
        if(x < 9 && y > 0)
            matrix[x + 1][y - 1].die();
    }

    public int getCountShips() {
        return countShips;
    }

    CellCondition getCondition(int x, int y) {
        return matrix[x][y].getCondition();
    }
}
