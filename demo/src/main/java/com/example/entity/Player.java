package com.example.entity;

import com.example.number.Vector3;
import com.example.util.DefaultSize;
import com.example.workspace.Camera;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.example.KeyHandler;


public class Player extends Entity {
    
    private final String playerSpriteFolder = "/sprites/player/";
    private final KeyHandler keyH;
    private final Double speed;

    private String direction;
    private int angle;
    private BufferedImage image;


    // CONSTRUCTORS
    public Player(
        Vector3 pos,
        KeyHandler keyH
    ) {
        super(pos);
        this.keyH = keyH;
        this.speed = 2.0;

        loadPlayerSprites();
    }


    // GETTERS


    public final void loadPlayerSprites() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(playerSpriteFolder + "/player_up_1.png"));
        } catch (IOException e) {}
    }


    @Override
    public void update() {

        Double xMove = 0.0;
        Double yMove = 0.0;
        
        if (keyH.upPressed() && !keyH.downPressed()) {
            direction = "up";
            angle = 0;
            yMove = -speed;
        }
        if (keyH.downPressed() && !keyH.upPressed()) {
            direction = "down";
            angle = 180;
            yMove = speed;
        }
        if (keyH.leftPressed() && !keyH.rightPressed()) {
            direction = (keyH.upPressed() ^ keyH.downPressed()) ? direction : "left";
            angle = -90;
            xMove = -speed;
        }
        if (keyH.rightPressed() && !keyH.leftPressed()) {
            direction = (keyH.upPressed() ^ keyH.downPressed()) ? direction : "right";
            angle = 90;
            xMove = speed;
        }


        super.move(new Vector3(xMove, yMove, 0.0));
    }


    @Override
    public void render(
        Graphics2D g2,
        Camera camera
    ) {
        Vector3 cameraPos = camera.getPos();
        double scale = camera.getScale();
        double size = DefaultSize.PLAYER;
        double screenX = pos.getX() - cameraPos.getX();
        double screenY = pos.getY() - cameraPos.getY();
        AffineTransform oldTransform = g2.getTransform();
        g2.rotate(Math.toRadians(angle), screenX, screenY);
        screenX -= (size/2);
        screenY -= (size/2);
        g2.drawImage(
            image, 
            (int)(screenX * scale), 
            (int)(screenY * scale), 
            (int)(size * scale), 
            (int)(size * scale), 
            null
        );
        g2.setTransform(oldTransform);
    }
}

