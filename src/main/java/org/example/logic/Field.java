package org.example.logic;

import org.example.PS;
import org.example.TypeCell;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int width,height;
    private Cell[][] array;
    private List<Cell> list;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        array = new Cell[height][width];
        list = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = new Cell(TypeCell.GRASS, 0);
                cell.setCoordinate(x,y);

                array[y][x] = cell;
                list.add(cell);
            }
        }
    }

    // get
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Cell> getList() {
        return list;
    }

    public Cell getCell(int x,int y){
        if(borderIn(x,y)){ return array[y][x]; }
        return null;
    }

    private boolean borderIn(int x, int y){
        return x>=0 && y>=0 && x< width && y<height;
    }

    public void reset(){
        for (Cell cell : list) {
            cell.setType(TypeCell.GRASS).setValue(0);
        }
    }

}
