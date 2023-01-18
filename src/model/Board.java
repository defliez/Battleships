package model;

import java.util.ArrayList;

public class Board {

    private ArrayList<Position> board;
    private Destroyer destroyer = new Destroyer();
    private Submarine submarine = new Submarine();

    public Board(int variation) {
        if (variation == 1) {
            /*
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
            */
        } else if (variation == 2) {


            board = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i % 2 == 0 && j == 0) {
                        Destroyer destroyer = new Destroyer();
                        board.add(new Position(i, j, destroyer));
                        board.add(new Position(i, j+1, destroyer));
                    } else if (i % 2 != 0 && j == 0) {
                        board.add(new Position(i, j, submarine));
                    } else {
                        board.add(new Position(i, j, null));
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                /*
                if (isShip(board.get(i * j).getX(), board.get(i * j).getY())) { //////////////////////////////
                    s += "S";
                } else {
                    s += "O";
                }
                 */


                if (getPosition(i, j).getShip() == submarine) {
                    s += "S";
                } else if(getPosition(i, j).getShip() != submarine && getPosition(i, j).getShip() != null) {
                    s += "D";
                } else {
                    s += "O";
                }
            }
            s += "\n";
        }

        return s;
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

    public Position getPosition(int x, int y) {
        for (Position p : board) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;

    }



    public ArrayList<Position> getBoard() {
        return board;
    }
}
