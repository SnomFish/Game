package com.example.entity;

import java.awt.Graphics2D;

import com.example.number.Vector3;
import com.example.workspace.Camera;

public class Entity {
    

    protected Vector3 pos = new Vector3();


    public Entity() {}
    public Entity(
        Vector3 pos
    ) {
        this.pos = pos;
    }


    // GETTERS
    public Vector3 getPos() {return pos;}


    // SETTERS


    public void update() {}
    public void render(Graphics2D g2, Camera camera) {}


    public void move(Vector3 b) {
        pos = pos.add(b);
    }
}
