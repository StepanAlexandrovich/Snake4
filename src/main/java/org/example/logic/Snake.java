package org.example.logic;

import org.example.AnimalMode;
import org.example.PS;
import org.example.TypeCell;

public class Snake {
    private int x,y;
    private int direction;
    private int length;

    private AnimalMode mode;

    public AnimalMode getMode() {
        return mode;
    }


    public void process(Field field){

        switch (direction){
            case 1: x++; break;
            case 2: y++; break;
            case 3: x--; break;
            case 4: y--; break;
        }

        Cell cell = field.getCell(x, y);
        if(cell == null){
            mode = AnimalMode.DEATH;
        }else
        if(cell.getType() == TypeCell.SNAKE){
            mode = AnimalMode.DEATH;
        }else
        if(cell.getType() == TypeCell.APPLE){
            mode = AnimalMode.EATING;
        }else
        if(cell.getType() == TypeCell.GRASS){
            mode = AnimalMode.MOVING;
        }


        if(mode == AnimalMode.MOVING || mode == AnimalMode.EATING){
            cell.setValue(length + 1).setType(TypeCell.SNAKE);
        }

        for (Cell cell1 : field.getList()) {
            if(cell1.getType() == TypeCell.SNAKE ){
                if(mode == AnimalMode.MOVING || mode == AnimalMode.DEATH){
                    cell1.setValue(cell1.getValue() - 1);
                    if(cell1.getValue() == 0){
                        cell1.setType(TypeCell.GRASS);
                    }
                }
            }
        }

        if(mode == AnimalMode.EATING){
            length++;
        }
    }

    // set
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /////////////
    public void place(){ direction = 0; }
    public void right(){ direction = 1; }
    public void down() { direction = 2; }
    public void left() { direction = 3; }
    public void up()   { direction = 4; }
}
