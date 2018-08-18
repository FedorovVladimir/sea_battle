package view.console;

import battlefield.*;
import game.Player;
import game.View;

import java.util.Scanner;

public class Console implements View {
    public void putFleet(Player player) {
        show(player.getField());
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            System.out.print("Ставим корабль: ");
            if(in.nextInt() == 1)
                player.getFleet().getShip(i).schangeOrientation();
            int y = getY(in);
            int x = getX(in);
            try {
                player.getField().stateShipOnFlied(player.getFleet().getShip(i), x, y);
            } catch (Exception e) {
                System.out.println("Туда нельзя, попробуйте снова.");
                i--;
            }
            show(player.getField());
        }

        System.out.println("Вы расставили корабли!");
        System.out.println();
    }

    private void show(Field field) {
        System.out.println("   а  б  в  г  д  е  ж  з  и  к");
        int number = 1;
        for (Cell[] row : field.getMatrix()) {
            if(number < 10)
                System.out.print(" ");
            System.out.print(number++ + " ");
            show(row);
            System.out.println();
        }
    }

    private static void show(Cell[] row) {
        for (Cell cell : row)
            show(cell);
    }

    private static void show(Cell cell) {
        CellCondition cellCondition = cell.getCondition();
        String text = "";
        if (cellCondition == CellCondition.EMPTY)
            text = "_";
        else if (cellCondition == CellCondition.SHIP)
            text = "S";
        else if (cellCondition == CellCondition.KILL_EMPTY)
            text = "*";
        else if (cellCondition == CellCondition.KILL_SHIP)
            text = "X";
        text += "  ";
        System.out.print(text);
    }

    private int getX(Scanner in) {
        int x = in.nextInt() - 1;
        return x;
    }

    private int getY(Scanner in) {
        String ch = in.next();
        int y = 0;
        if(ch.equals("а"))
            y = 0;
        else if (ch.equals("б"))
            y = 1;
        else if (ch.equals("в"))
            y = 2;
        else if (ch.equals("г"))
            y = 3;
        else if (ch.equals("д"))
            y = 4;
        else if (ch.equals("е"))
            y = 5;
        else if (ch.equals("ж"))
            y = 6;
        else if (ch.equals("з"))
            y = 7;
        else if (ch.equals("и"))
            y = 8;
        else if (ch.equals("к"))
            y = 9;
        return y;
    }

    public void step(Player player, Player he) {
        show(player.getField(), he.getField());
        System.out.println("Стреляй " + player.getName() + "(буква цифра): ");
        Scanner in = new Scanner(System.in);

        int y = getY(in);
        int x = getX(in);

        if(!he.getField().shot(x, y, he.getFleet())) {
            player.setStep(false);
            System.out.println("Мимо");
        } else {
            System.out.println("Попал");
        }

        if(he.getFleet().getCountShips() == 0)
            player.setWin(true);
    }

    private void show(Field field, Field heField1) {
        System.out.print("   а  б  в  г  д  е  ж  з  и  к     ");
        System.out.println("   а  б  в  г  д  е  ж  з  и  к");
        for (int i = 0; i < field.getMatrix().length; i++) {
            show(field.getMatrix()[i], heField1.getMatrix()[i], i);
            System.out.println();
        }
    }

    private void show(Cell[] cells, Cell[] heCells, int i) {
        if(i < 9)
            System.out.print(" ");
        System.out.print(i + 1 + " ");
        for (Cell cell : cells)
            show(cell);

        System.out.print("    ");

        if(i < 9)
            System.out.print(" ");
        System.out.print(i + 1 + " ");
        for (Cell cell : heCells)
            showHe(cell);
    }

    private void showHe(Cell cell) {
        CellCondition cellCondition = cell.getCondition();
        String text = "";
        if (cellCondition == CellCondition.EMPTY)
            text = "_";
        else if (cellCondition == CellCondition.SHIP)
            text = "_";
        else if (cellCondition == CellCondition.KILL_EMPTY)
            text = "*";
        else if (cellCondition == CellCondition.KILL_SHIP)
            text = "X";
        text += "  ";
        System.out.print(text);
    }

    public void win(String name) {
        System.out.println(name + ", you win!!!");
    }

    public void lose() {
        System.out.println("You lose(((");
    }
}
