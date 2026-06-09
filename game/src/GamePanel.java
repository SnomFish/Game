package game.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.src.entity.Player;
import game.src.world.MapManager;
import game.src.world.MapRenderer;
import game.src.world.TileManager;

public class GamePanel extends JPanel implements Runnable {
    
    public final int originalTileSize = 16;
    public final double scale = 4;
    public final int tileSize = (int)(originalTileSize * scale);
    
    private final int defaultMaxScreenCol = 12;
    private final int defaultMaxScreenRow = 8;

    private final int screenWidth = tileSize * defaultMaxScreenCol;
    private final int screenHeight = tileSize * defaultMaxScreenRow;


    private final Camera camera;
    private final TileManager tileManager;
    private final MapManager mapManager;
    private final MapRenderer mapRenderer;
    private final KeyHandler keyH;
    private final Player player;



    private int FPS = 60;
    private Thread gameThread; // I KNOW THREADS!
    
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true); // TO DO: Figure out what this does
        this.setFocusable(true);  // TO DO: Figure out what this does

        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        player = new Player(keyH);

        camera = new Camera();
        tileManager = new TileManager();
        mapManager = new MapManager();
        mapManager.setCurrentMap(0);
        mapRenderer = new MapRenderer();
    }


    // getters
    public int getTileSize() {return tileSize;}
    public int getScreenWidth() {return screenWidth;}
    public int getScreenHeight() {return screenHeight;}


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
        player.update();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        
        mapRenderer.render(g2, camera, tileManager, mapManager);
        player.render(g2, camera);

        g2.dispose();
    }
}
