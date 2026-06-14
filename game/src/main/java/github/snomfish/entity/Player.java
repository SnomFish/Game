package github.snomfish.entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import github.snomfish.KeyHandler;
import github.snomfish.MouseHandler;
import github.snomfish.Renderer;


public class Player extends Entity {
    
    private final String playerSpriteFolder = "/player/";
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;

    private final double speed;
    private final double direction;

    private BufferedImage image;


    // CONSTRUCTORS
    public Player(
        KeyHandler keyHandler,
        MouseHandler mouseHandler
    ) {
        this.size = 16;
        this.worldPosX = 0;
        this.worldPosY = 0;

        this.keyHandler = keyHandler;
        this.mouseHandler = mouseHandler;
        
        this.speed = 2;
        this.direction = 0;
        loadPlayerSprites();
    }



    public final void loadPlayerSprites() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(playerSpriteFolder + "/player_up_1.png"));
        } catch (IOException e) {}
    }


    @Override
    public void update() {
        if (keyHandler.upPressed() && !keyHandler.downPressed()) {
            worldPosY -= speed;
        }
        if (keyHandler.downPressed() && !keyHandler.upPressed()) {
            worldPosY += speed;
        }
        if (keyHandler.leftPressed() && !keyHandler.rightPressed()) {
            worldPosX -= speed;
        }
        if (keyHandler.rightPressed() && !keyHandler.leftPressed()) {
            worldPosX += speed;
        }
    }


    @Override
    public void render(
        Renderer renderer
    ) {
        renderer.render(
            image,
            worldPosX,
            worldPosY,
            size,
            size
        );
    }
}
