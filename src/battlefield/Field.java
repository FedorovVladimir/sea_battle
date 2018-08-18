package battlefield;

public class Field {
    private int size = 10;
    private Cell[][] matrix = new Cell[size][size];

    public Field() {
        for (int i = 0; i < size; i++) {
            matrix[i] = new Cell[size];
            for (int j = 0; j < size; j++)
                matrix[i][j] = new Cell();
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    private void stateShip(Ship ship, int x, int y) {
        if(isSecurityPosition(ship, x, y)) {
            state(ship, x, y);
        }
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

    private boolean isSecurityPosition(int x, int y) {
        boolean isSecurityPosition = isEmpty(matrix[x][y]);

        if(x > 0)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x - 1][y]);
        if(x < 9)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x + 1][y]);
        if(y > 0)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x][y - 1]);
        if(y < 9)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x][y + 1]);
        if(x > 0 && y > 0)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x - 1][y - 1]);
        if(x > 0 && y < 9)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x - 1][y + 1]);
        if(x < 9 && y < 9)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x + 1][y + 1]);
        if(x < 9 && y > 0)
            isSecurityPosition = isSecurityPosition && isEmpty(matrix[x + 1][y - 1]);

        return isSecurityPosition;
    }

    private boolean isEmpty(Cell cell) {
        return cell.getCondition() == CellCondition.EMPTY;
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

    public void stateShipOnFlied(Ship ship, int x, int y) throws Exception {
        if(isSecurityPosition(ship, x, y))
            stateShip(ship, x, y);
        else
            throw new Exception("Здесь нельзя");
    }

    public boolean shot(int x, int y, Fleet fleet) {
        boolean isKill =  matrix[x][y].shot();
        if(isKill)
            fleet.calcCountShips(this);
        return isKill;
    }
}
