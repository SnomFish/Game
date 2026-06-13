package github.snomfish.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import github.snomfish.Camera;
import github.snomfish.KeyHandler;
import github.snomfish.number.Vector3;


public class Player extends Entity {
    
    private final String playerSpriteFolder = "/player/";
    private final KeyHandler keyHandler;
    private final Double speed;

    private String direction;
    private BufferedImage image;


    // CONSTRUCTORS
    public Player(
        Vector3 pos,
        KeyHandler keyHandler
    ) {
        super(pos, 16);
        this.keyHandler = keyHandler;
        this.speed = 2.0;
        loadPlayerSprites();
    }



    public final void loadPlayerSprites() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(playerSpriteFolder + "/player_up_1.png"));
        } catch (IOException e) {}
    }


    @Override
    public void update() {

        Double xMove = 0.0;
        Double yMove = 0.0;
        
        if (keyHandler.upPressed() && !keyHandler.downPressed()) {
            direction = "up";
            yMove = -speed;
        }
        if (keyHandler.downPressed() && !keyHandler.upPressed()) {
            direction = "down";
            yMove = speed;
        }
        if (keyHandler.leftPressed() && !keyHandler.rightPressed()) {
            direction = (keyHandler.upPressed() ^ keyHandler.downPressed()) ? direction : "left";
            xMove = -speed;
        }
        if (keyHandler.rightPressed() && !keyHandler.leftPressed()) {
            direction = (keyHandler.upPressed() ^ keyHandler.downPressed()) ? direction : "right";
            xMove = speed;
        }


        super.move(new Vector3(xMove, yMove, 0.0));
    }


    @Override
    public void render(
        Graphics2D g2,
        Camera camera
    ) {
        double scale = camera.getScale();

        Vector3 cameraRenderPos = camera.getRenderPos();
        Vector3 renderPos = getRenderPos();
        Vector3 screenPos = renderPos.sub(cameraRenderPos).mul(scale);

        g2.drawImage(
            image,
            (int) (screenPos.getX()),
            (int) (screenPos.getY()),
            (int) (size * scale),
            (int) (size * scale),
            null
        );
    }
}
