package github.snomfish.tile;

import java.awt.image.BufferedImage;

public abstract class Tile {
    

    public static int SIZE = 16;
    public static int SIZE_Y = 16;
    public static int HEIGHT = 3;

    protected String name;


    public Tile() {}

    
    public String getName() {return name;}
    public abstract BufferedImage getImage(int x, int y);
}
