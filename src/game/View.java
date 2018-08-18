package game;

public interface View {
    void putFleet(Player player);
    void step(Player player, Player he);

    void win(String name);
    void lose();
}
