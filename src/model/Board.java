package model;

import controller.Controller;
import java.util.Random;

public class Board {

    private Controller controller;
    private Ship[][] gameBoard;
    private int totalNumOfShips;
    private Submarine submarine;
    private Torpedo torpedo;
    private Hunter hunter;
    private Cruiser cruiser;
    private Battleship battleship;

    public Board(Controller controller, int version) {
        this.controller = controller;
        gameBoard = new Ship[10][10];
        submarine = new Submarine();
        torpedo = new Torpedo();
        hunter = new Hunter();
        cruiser = new Cruiser();
        battleship = new Battleship();
        totalNumOfShips = 15;

        if (version == 1) {
            placeShipsVersion1();
        } else if (version == 2) {
            placeShipsVersion2();
        }
    }

    private void placeShipsVersion1() {
        // Hardcoded ship placements for version 2
        placeShip(submarine, 0, 0, true); // Vertical submarine at position (0, 0)
        placeShip(hunter, 3, 4, false);   // Horizontal hunter at position (3, 4)
        placeShip(cruiser, 6, 2, true);   // Vertical cruiser at position (6, 2)
        placeShip(torpedo, 8, 7, false);   // Horizontal torpedo at position (8, 7)
        placeShip(battleship, 1, 6, false); // Horizontal battleship at position (1, 6)
    }

    private void placeShipsVersion2() {
        // Hardcoded ship placements for version 3
        placeShip(submarine, 2, 3, true); // Vertical submarine at position (2, 3)
        placeShip(hunter, 5, 9, false);    // Horizontal hunter at position (5, 9)
        placeShip(cruiser, 7, 5, true);   // Vertical cruiser at position (7, 5)
        placeShip(torpedo, 4, 1, false);   // Horizontal torpedo at position (4, 1)
        placeShip(battleship, 0, 0, true); // Vertical battleship at position (0, 0)
    }

    private void placeShip(Ship ship, int x, int y, boolean vertical) {
        int size = ship.getSize();
        int boardSize = gameBoard.length;

        if (x < 0 || y < 0 || x >= boardSize || y >= boardSize) {
            // Invalid position, ship cannot be placed
            return;
        }

        if (vertical) {
            if (y + size - 1 >= boardSize) {
                // Ship exceeds the bounds vertically, cannot be placed
                return;
            }

            for (int i = y; i < y + size; i++) {
                if (gameBoard[i][x] != null) {
                    // Collision with another ship, cannot be placed
                    return;
                }
            }

            for (int i = y; i < y + size; i++) {
                gameBoard[i][x] = ship;
            }
        } else {
            if (x + size - 1 >= boardSize) {
                // Ship exceeds the bounds horizontally, cannot be placed
                return;
            }

            for (int i = x; i < x + size; i++) {
                if (gameBoard[y][i] != null) {
                    // Collision with another ship, cannot be placed
                    return;
                }
            }

            for (int i = x; i < x + size; i++) {
                gameBoard[y][i] = ship;
            }
        }
    }

    public boolean fireAt (int x, int y) {
        if (gameBoard[y][x] != null) { //
            gameBoard[y][x].setSize(gameBoard[y][x].getSize() - 1);  //
            String shipType = gameBoard[y][x].toString();
            controller.setGameEvents("You hit a: " + shipType + "!");
            totalNumOfShips--;

            if (gameBoard[y][x].getSize() < 1) {
                controller.setGameEvents("You SANK a: " + shipType + "!");
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean winCondition() {
        if (totalNumOfShips != 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
