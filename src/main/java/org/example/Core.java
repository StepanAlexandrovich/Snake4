package org.example;

import org.example.logic.Apple;
import org.example.logic.Cell;
import org.example.logic.Field;
import org.example.logic.Snake;

public class Core {
    private int width = 20,height = 20;
    private Field field = new Field(width,height);

    private Snake snake = new Snake();
    private Apple apple = new Apple();

    private GameState gameState = GameState.PROCESS;

    private int score,step;


    public Core() {
        initialization();
    }

    private void initialization(){
        field.reset();

        field.getCell(4,6).setType(TypeCell.APPLE).setValue(0);
        field.getCell(7,6).setType(TypeCell.APPLE).setValue(0);
        field.getCell(10,8).setType(TypeCell.APPLE).setValue(0);

        snake.setX(2);
        snake.setY(1);

        snake.setDirection(1);
        snake.setLength(1);

        score = 0;
        step = 0;
    }
    // get
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Field getField() {
        return field;
    }

    public GameState getGameState() {
        return gameState;
    }

    /////////////

    public void restart(){
        initialization();
        gameState = GameState.PROCESS;
    }

    public void place(){ snake.place(); }
    public void right(){ snake.right(); }
    public void down() { snake.down(); }
    public void left() { snake.left();}
    public void up()   { snake.up(); }

    public void process(){
        if(gameState == GameState.PROCESS){
            step++;

            snake.process(field);

            if(snake.getMode() == AnimalMode.EATING){
                score++;
            }

            if(snake.getMode() == AnimalMode.DEATH){
                gameState = GameState.DEFEAT;
            }else
            if(score > 2){
                gameState = GameState.WINNING;
            }else
            if(step == 30){
                gameState = GameState.DEFEAT;
            }

        }

    }



}
