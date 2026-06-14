package github.snomfish.ui;

import java.awt.Graphics2D;

public abstract class UIElement {
    
    protected int x;
    protected int y;
    protected int layer;


    public UIElement () {}


    public int getX() {return x;}
    public int getY() {return y;}
    public int getLayer() {return layer;}


    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setLayer(int layer) {this.layer = layer;}


    public abstract void update();
    public abstract void render(Graphics2D g2);
}
