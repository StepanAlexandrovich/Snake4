package org.example;

import org.example.visualization.CanvasFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main implements ActionListener {
    private Core core;
    private CanvasFrame canvasFrame;

    public Main() {
        core = new Core();
        canvasFrame = new CanvasFrame(core.getWidth(),core.getHeight());

        canvasFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT: core.right(); break;
                    case KeyEvent.VK_DOWN: core.down(); break;
                    case KeyEvent.VK_LEFT: core.left(); break;
                    case KeyEvent.VK_UP: core.up(); break;
                    case KeyEvent.VK_ENTER: core.restart(); break;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        core.process();
        canvasFrame.update(core);
    }

    ////////////////////////////
    public static void main(String[] args) {
        Timer timer = new Timer(500,new Main());
        timer.start();
    }
}