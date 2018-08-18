package battlefield;

public class Fleet {
    private int countShips = 10;
    private Ship[] ships = new Ship[countShips];

    public Fleet() {
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

    public Ship[] getShips() {
        return ships;
    }

    public Ship getShip(int i) {
        return ships[i];
    }

    public int getCountShips() {
        return countShips;
    }

    void calcCountShips(Field field) {
        countShips = 0;
        for (Ship ship: ships) {
            if(ship.live(field))
                countShips++;
        }
    }
}
