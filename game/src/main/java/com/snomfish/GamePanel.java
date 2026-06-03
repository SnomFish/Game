

package com.snomfish;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


class GamePanel extends JPanel implements Runnable {

    public final int screenWidth = 1280;
    public final int screenHeight = 720;

    Thread gameThread;
    int FPS = 60;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK); // Set a background color
        this.setDoubleBuffered(true); // Enables better rendering performance
        //this.addKeyListener(keyH);
        this.setFocusable(true);
    }



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

                //gameThread = null;
                
                delta--;
            }

        }
    }



    public void update() {
        //System.out.println("updating");
    }


    public void repaint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        

        g2.dispose();
    }
}
