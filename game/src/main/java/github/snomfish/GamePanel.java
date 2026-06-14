package github.snomfish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import github.snomfish.camera.Camera;
import github.snomfish.ui.UIContainer;

public class GamePanel extends JPanel implements Runnable {


    public static int SCREEN_WIDTH = 768;
    public static int SCREEN_HEIGHT = 512;
    
    public static Font defaultFont = new Font("Ariel", Font.PLAIN, 24);
    public static Color defaultFontColour = Color.BLACK;
    
    private final Camera camera;
    private final Renderer renderer;
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;
    private final Workspace workspace;
    private final UIContainer uiContainer;

    private int FPS = 60;
    private Thread gameThread; // I KNOW THREADS!
    
    
    public GamePanel() {
        keyHandler = new KeyHandler();
        camera = new Camera(keyHandler);
        renderer = new Renderer(camera);
        mouseHandler = new MouseHandler(camera);
        workspace = new Workspace(camera, keyHandler, mouseHandler);
        uiContainer = new UIContainer();

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

    
    public static int trueFPS;
    private long lastSecond;
    private int fpsCounter;


    @Override
    public void run() {

        double _1second = 1000000000;
        double drawInterval = _1second / FPS;
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

                fpsCounter++;

                delta--;
            }

            if (currentTime >= lastSecond + _1second) {
                trueFPS = fpsCounter;
                fpsCounter = 0;
                lastSecond = currentTime;
            }
        }
    }


    public void update() {
        workspace.update();
        uiContainer.update();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        renderer.setGraphics2D(g2);

        workspace.render(renderer);
        uiContainer.render(g2);

        g2.dispose();
    }
}
