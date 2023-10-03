package model;

public abstract class Ship {

    private int size;
    ShipType shipType;
    boolean[] hits;

    public Ship(int size, ShipType shipType) {
        this.size = size;
        this.shipType = shipType;
        this.hits = new boolean[size];
        for (int i = 0; i < size; i++) {
            hits[i] = false;
        }
    }


    public int getSize() {
        return size;
    }

    public void setSize(int length) {
        this.size = length;
    }
    @Override
    public String toString() {
        return String.format("%s ", shipType);
    }
}
