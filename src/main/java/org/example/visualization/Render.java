package org.example.visualization;

import org.example.Core;
import org.example.GameState;
import org.example.TypeCell;
import org.example.logic.Cell;
import org.example.logic.Field;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

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


        Field field = core.getField();
        List<Cell> list = field.getList();

        for (Cell cell : list) {
            int bright = 60;
            int value = cell.getValue()*bright;
            if(value > 255) { value = 255; }

            if(cell.getType() == TypeCell.SNAKE){
                g.setColor(new Color(0,0,value));
                g.fillRect(cell.getX()*multiplication,cell.getY()*multiplication,multiplication,multiplication);
            }
            if(cell.getType() == TypeCell.APPLE){
                g.setColor(Color.RED);
                g.fillOval(cell.getX()*multiplication,cell.getY()*multiplication,multiplication,multiplication);
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
