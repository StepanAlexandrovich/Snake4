package org.example;

public class Core {
    private int x,y;
    private int direction;

    private int width = 40,height = 30;
    private int[][] field;
    private int[][] snake;
    private int length;

    private GameState gameState = GameState.PROCESS;

    private int score,step;

    private enum AnimalMode { MOVING,EATING,DEATH }
    private AnimalMode snakeMode;

    public Core() {
        initialization();
    }

    private void initialization(){
        field = new int[height][width];
        snake = new int[height][width];

        field[4][6] = 2;
        field[6][6] = 2;
        field[10][8] = 2;

        x = 2;
        y = 1;
        direction = 1;
        length = 1;

        score = 0;
        step = 0;

        //mode = Mode.MOVING;
    }
    // get
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getField() {
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

    public void place(){ direction = 0; }
    public void right(){ direction = 1; }
    public void down() { direction = 2; }
    public void left() { direction = 3; }
    public void up()   { direction = 4; }

    public void process(){
        if(gameState == GameState.PROCESS){
            step++;

            //////// snake ///////
            switch (direction){
                case 1: x++; break;
                case 2: y++; break;
                case 3: x--; break;
                case 4: y--; break;
            }

            if(!borderIn(x,y)){
                snakeMode = AnimalMode.DEATH;
            }else
            if(field[y][x] == 1 ){
                snakeMode = AnimalMode.DEATH;
            }else
            if(field[y][x] == 2){
                snakeMode = AnimalMode.EATING;
            }else
            if(field[y][x] == 0){
                snakeMode = AnimalMode.MOVING;
            }


            if(snakeMode == AnimalMode.MOVING || snakeMode == AnimalMode.EATING){
                snake[y][x] = length + 1;
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if(snake[y][x]>0){
                        if(snakeMode == AnimalMode.MOVING || snakeMode == AnimalMode.DEATH){
                            snake[y][x]--;
                        }

                        if(snake[y][x]>0){
                            field[y][x] = 1;
                        }else{
                            field[y][x] = 0;
                        }
                    }
                }
            }
            if(snakeMode == AnimalMode.EATING){
                length++;
            }
            /////////////////////////////
            if(snakeMode == AnimalMode.EATING){
                score++;
            }

            if(snakeMode == AnimalMode.DEATH){
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

    private boolean borderIn(int x,int y){
        return x>=0 && y>=0 && x<width && y<height;
    }

}
