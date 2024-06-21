package org.example.logic;

public class Cell {
    private int type;
    private int value;

    private int x,y;

    public Cell(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public Cell setType(int type) {
        this.type = type;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Cell setValue(int value) {
        this.value = value;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
