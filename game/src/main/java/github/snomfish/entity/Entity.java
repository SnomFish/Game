package github.snomfish.entity;

import java.awt.Graphics2D;

import github.snomfish.Camera;
import github.snomfish.number.Vector3;

public class Entity {
    

    protected Vector3 pos;
    protected int size;


    public Entity() {}
    public Entity(
        Vector3 pos,
        int size
    ) {
        this.pos = pos;
        this.size = size;
    }


    public Vector3 getPos() {return pos;}
    public Vector3 getRenderPos() {return new Vector3(
        pos.getX() - (size / 2),
        pos.getY() - (size / 2),
        pos.getZ());
    } // the position that should exist on the screen
    public int getSize() {return size;}


    public void setPos(Vector3 pos) {this.pos = pos;}
    public void setSize(int size) {this.size = size;}


    public void update() {}
    public void render(Graphics2D g2, Camera camera) {}


    public void move(Vector3 b) {
        pos = pos.add(b);
    }
}
