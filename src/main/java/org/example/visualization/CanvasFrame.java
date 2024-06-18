package org.example.visualization;

import org.example.Core;

import javax.swing.*;
import java.awt.*;

public class CanvasFrame extends JFrame {
    private Render render;
    private Canvas canvas;

    public CanvasFrame(int width,int height) {
        render = new Render(width,height);
        canvas = new Canvas();

        canvas.setSize(render.getWidth(),render.getHeight());

        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        this.getContentPane().add(canvas);
        this.setBounds(0,0, render.getWidth() + 15, render.getHeight() + 25);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void update(Core core){
        render.process(core);

        Graphics graphics = canvas.getGraphics();
        graphics.drawImage(render.getImage(),0,0,null);
    }
}
