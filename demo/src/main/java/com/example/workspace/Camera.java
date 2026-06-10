package com.example.workspace;

import com.example.number.Vector3;
import com.example.util.DefaultSize;
import com.example.world.GameMap;

public class Camera {
    
    private Vector3 pos;
    private int screenWidth;
    private int screenHeight;
    private double scale;


    // CONSTRUCTORS
    public Camera(Vector3 defaultPos) {
        this.pos = defaultPos;
        scale = 1;
    }


    // GETTERS
    public Vector3 getPos() {return pos;}
    public int getScreenWidth() {return screenWidth;}
    public int getScreenHeight() {return screenHeight;}
    public double getScale() {return scale;}


    // SETTERS
    public void setPos(Vector3 pos) {this.pos = pos;}
    public void setScreenWidth(int screenWidth) {this.screenWidth = screenWidth;}
    public void setScreenHeight(int screenHeight) {this.screenHeight = screenHeight;}
    public void setScale(double scale) {this.scale = scale;}


    public void update(
        Vector3 playerPos,
        GameMap map
    ) {
        pos = playerPos.clone();
        pos.alterX( -(DefaultSize.SCREENWIDTH / (2 * scale)) );
        pos.alterY( -(DefaultSize.SCREENHEIGHT / (2 * scale)) );
    }
}
