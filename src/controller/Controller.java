package controller;

import model.Board;
import model.Position;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Board board = new Board(2);

        System.out.println(board.toString());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter x coordinate: ");
            int x = scanner.nextInt();
            System.out.println("Enter y coordinate: ");
            int y = scanner.nextInt();
            Position position = board.getPosition(x, y);
            System.out.println(board.getPosition(x, y).isShip(x, y));
        }
    }
}
