package github.snomfish.entity;

import github.snomfish.Renderer;

public abstract class Entity {
    

    protected int worldPosX;
    protected int worldPosY;
    protected int size;


    public Entity() {}


    public int getWorldPosX() {return worldPosX;}
    public int getWorldPosY() {return worldPosY;}
    public int getSize() {return size;}


    public void setWorldPosX(int worldPosX) {this.worldPosX = worldPosX;}
    public void setWorldPosY(int worldPosY) {this.worldPosY = worldPosY;}
    public void setSize(int size) {this.size = size;}


    public abstract void update();
    public abstract void render(Renderer renderer);
}
