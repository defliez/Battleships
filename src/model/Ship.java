package model;

public class Ship {

    private int length;
    private boolean sunk = false;
    private Orientation orientation;
    boolean[] hits;
    int x;
    int y;

    public Ship(int x, int y, int length, Orientation orientation) {
        this.length = length;
        this.orientation = orientation;
        this.hits = new boolean[length];
        //this.hits = new boolean[]{false, false, false, false, false};
        for (int i = 0; i < length; i++) {
            hits[i] = false;
        }
        this.x = x;
        this.y = y;
    }

    public boolean checkHit(int x, int y) {
        if (orientation == Orientation.HORIZONTAL) {
            if (x >= this.x && x < this.x + length && y == this.y) {
                int index = x - this.x;
                hits[index] = true;
                return true;
            }
        } else {
            if (y >= this.y && y < this.y + length && x == this.x) {
                int index = y - this.y;
                hits[index] = true;
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isSunk() {
        for (boolean hit : hits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    /*
    public boolean isSunk() {
        return sunk;
    }
    */

    public Orientation getOrientation() {
        return orientation;
    }
    public void isHit() {
        setLength(length - 1);
        if (length == 0) {
            sunk = true;
        }
    }

    public void setHit(boolean[] hits) {
        this.hits = hits;
    }


}
