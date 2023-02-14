package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Ship> ships = new ArrayList<>();
    private Position[][] board;
    //private Destroyer destroyer = new Destroyer();
    //private Submarine submarine = new Submarine();

    private int numRemainingShips = 3;

    public Board(int variation) {
        ships.add(new Ship(0, 0, 4, Orientation.HORIZONTAL));
        ships.add(new Ship(2, 2, 3, Orientation.VERTICAL));
        /*
        if (variation == 1) {

            board = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int randomNum = (int) (Math.random() * 10);
                for (int j = 0; j < 10; j++) {
                    board.add(new Position(j, i));
                    if (j == randomNum) {
                        getPosition(j, i).setShip(true);
                    } else {
                        getPosition(j, i).setShip(false);
                    }
                }
            }

        } else if (variation == 2) {


            board = new Position[10][10];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i % 2 == 0 && j == 0) {
                        Destroyer destroyer = new Destroyer();
                        //board.add(new Position(i, j, destroyer));
                        board[i][j] = new Position(i, j, destroyer);
                        //board.add(new Position(i, j+1, destroyer));
                        board[i][j+1] = new Position(i, j+1, destroyer);
                    } else if (i % 2 != 0 && j == 0) {
                        //board.add(new Position(i, j, submarine));
                        board[i][j] = new Position(i, j, submarine);
                    } else {
                        //board.add(new Position(i, j, null));
                        board[i][j] = new Position(i, j, null);
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                }
            }
        }
        */


    }
    /*
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //////////////////////////////
                if (isShip(board.get(i * j).getX(), board.get(i * j).getY())) { //////////////////////////////
                    s += "S";
                } else {
                    s += "O";
                }
                //////////////////////////////


                if (getBoard()[i][j].getShip() == submarine) {
                    s += "S";
                } else if(getBoard()[i][j].getShip() != submarine && getBoard()[i][j].getShip() != null) {
                    s += "D";
                } else {
                    s += "O";
                }
            }
            s += "\n";
        }

        return s;
    }

     */

    public void markShipAsSunk() {
        numRemainingShips--;
    }

    public int getNumRemainingShips() {
        return numRemainingShips;
    }

    public Result checkHit(int x, int y) {
        for (Ship ship : ships) {
            if (ship.checkHit(x, y)) {
                if (ship.isSunk()) {            // check for loop above
                    markShipAsSunk();
                    return Result.SUNK;
                } else {
                    //ship.checkHit(x, y);
                    return Result.HIT;
                }
            }
        }
        return Result.MISS;
    }


    public boolean[][] getShipLocations() {
        int rows = 10; // assume a 10x10 game board
        int cols = 10;
        boolean[][] shipLocations = new boolean[rows][cols];
        for (Ship ship : ships) {
            int x = ship.x;
            int y = ship.y;
            if (ship.getOrientation() == Orientation.HORIZONTAL) {
                for (int i = 0; i < ship.getLength(); i++) {
                    shipLocations[x + i][y] = true;
                }
            } else {
                for (int i = 0; i < ship.getLength(); i++) {
                    shipLocations[x][y + i] = true;
                }
            }
        }
        return shipLocations;
    }

    /*
    public boolean isHit(Position position) {
        for (Position p : board) {
            if (p.equals(position)) {
                return p.isShip();
            }
        }
        return false;
    }

     */

    /*
    public Position getPosition(int x, int y) {
        for (Position p : board) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;

    }
     */


    public Position[][] getBoard() {
        return board;
    }
}
