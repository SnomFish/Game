package game.src.entity;

import game.src.Camera;
import java.awt.Graphics2D;

import game.src.number.Vector3;

public class Entity {
    

    protected Vector3 pos = new Vector3();


    public Entity() {}
    public Entity(Vector3 pos) {this.pos = pos;}


    public Vector3 getPos() {return pos;}


    public void update() {}
    public void render(Graphics2D g2, Camera camera) {}


    public void move(Vector3 b) {
        pos = pos.add(b);
    }
}
