package github.snomfish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {


    public static int SCREEN_WIDTH = 768;
    public static int SCREEN_HEIGHT = 512;
    
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;
    private final Workspace workspace;

    private int FPS = 30;
    private Thread gameThread; // I KNOW THREADS!
    
    
    public GamePanel() {
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
        workspace = new Workspace(keyHandler, mouseHandler);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true); // TO DO: Figure out what this does
        this.setFocusable(true);  // TO DO: Figure out what this does

        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
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
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        workspace.render(g2);
        g2.dispose();
    }
}
