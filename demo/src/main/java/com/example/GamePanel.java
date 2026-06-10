package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.example.util.DefaultSize;
import com.example.workspace.Workspace;

public class GamePanel extends JPanel implements Runnable {


    private final KeyHandler keyH;
    private final MouseHandler mouseH;
    private final Workspace workspace;


    private int FPS = 30;
    private Thread gameThread; // I KNOW THREADS!
    
    
    public GamePanel() {
        keyH = new KeyHandler();
        mouseH = new MouseHandler();
        workspace = new Workspace(keyH, mouseH);

        this.setPreferredSize(new Dimension(DefaultSize.SCREENWIDTH, DefaultSize.SCREENHEIGHT));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true); // TO DO: Figure out what this does
        this.setFocusable(true);  // TO DO: Figure out what this does

        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
    }


    // setters
    public void setFPS(int FPS) {this.FPS = FPS;}


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();

                delta--;
            }
        }
    }


    public void update() {
        workspace.update();
        System.out.println(mouseH.toString());
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        workspace.render(g2);
        g2.dispose();
    }
}