package model;

import java.util.ArrayList;

public class Position {
    private int x;
    private int y;
    private Ship ship;

    // private ArrayList<Position> board = new ArrayList<Position>();

    public Position(int x, int y, Ship ship) {
        this.x = x;
        this.y = y;
        this.ship = ship;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean equals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isShip(int x, int y) {
        /*
        boolean isShip = false;
        for (Position p : board) {
            if (p.getX() == x && p.getY() == y) {
                if (board.get(x * y).getShip() == null) {
                    isShip = false;
                } else {
                    isShip = true;
                }
            }
        }
        return isShip;

         */
        if (ship == null) {
            return false;
        } else {
            return true;
        }
    }

    /*
    public boolean isShip(int x, int y) {
        if (ship == null) {
            return false;
        } else {
            return true;
        }
    }

     */
}
