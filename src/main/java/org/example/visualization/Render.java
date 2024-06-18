package org.example.visualization;

import org.example.Core;
import org.example.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {
    private int multiplication;
    private int width,height;
    private BufferedImage image;

    private Graphics g;


    public Render(int width, int height) {
        multiplication = 20;
        this.width = width*multiplication;
        this.height = height*multiplication;

        image = new BufferedImage(this.width,this.height,BufferedImage.TYPE_INT_ARGB);
        g = image.getGraphics();
    }

    // get
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }

    // drawing
    private int i = 0;
    public void process( Core core ){


        g.setColor(Color.GREEN);
        g.fillRect(0,0,width,height);


        int[][] field = core.getField();

        for (int y = 0; y < core.getHeight(); y++) {
            for (int x = 0; x < core.getWidth(); x++) {
                if(field[y][x] == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(x*multiplication,y*multiplication,multiplication,multiplication);
                }
                if(field[y][x] == 2){
                    g.setColor(Color.RED);
                    g.fillOval(x*multiplication,y*multiplication,multiplication,multiplication);
                }

            }
        }

        switch (core.getGameState()){
            case DEFEAT: showText("DEFEAT"); break;
            case WINNING: showText("WINNING"); break;
        }

    }

    private void showText(String text){
        Font font = new Font("Arial",Font.BOLD,20);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(text,0,20);
    }

}
