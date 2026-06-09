package game.src.entity;

import game.src.Camera;
import game.src.KeyHandler;
import game.src.number.Vector3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Entity {
    
    private final KeyHandler keyH;
    private final Double speed;

    private String direction;
    private BufferedImage image;

    private final int originalSize = 16;


    // CONSTRUCTORS
    public Player(KeyHandler keyH) {
        super(Vector3.unit());
        this.keyH = keyH;
        this.speed = 0.2;

        loadPlayerSprites();
    }


    // GETTERS
    public int getOriginalSize() {return originalSize;}


    public final void loadPlayerSprites() {
        String spriteFilePath = "/game/res/sprites";
        try {
            image = ImageIO.read(getClass().getResourceAsStream(spriteFilePath + "/player/player_up_1.png"));
        } catch (IOException e) {}
    }


    @Override
    public void update() {

        Double xMove = 0.0;
        Double yMove = 0.0;
        
        if (keyH.upPressed() && !keyH.downPressed()) {
            direction = "up";
            yMove = -speed;
        }
        if (keyH.downPressed() && !keyH.upPressed()) {
            direction = "down";
            yMove = speed;
        }
        if (keyH.leftPressed() && !keyH.rightPressed()) {
            direction = (keyH.upPressed() ^ keyH.downPressed()) ? direction : "left";
            xMove = -speed;
        }
        if (keyH.rightPressed() && !keyH.leftPressed()) {
            direction = (keyH.upPressed() ^ keyH.downPressed()) ? direction : "right";
            xMove = speed;
        }


        super.move(new Vector3(xMove, yMove, 0.0));
    }


    @Override
    public void render(
        Graphics2D g2,
        Camera camera
    ) {
        int size = (int) (originalSize * camera.getScale());
        int screenX = (int) (size * pos.getX());
        int screenY = (int) (size * pos.getY());
        
        g2.drawImage(image, screenX, screenY, size, size, null);
    }
}

