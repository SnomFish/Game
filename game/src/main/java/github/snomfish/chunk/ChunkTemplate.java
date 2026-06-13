package github.snomfish.chunk;

import github.snomfish.tile.Tile;

public class ChunkTemplate {
    
    public static int SIZE = Tile.SIZE * 16;
    public static int LENGTH = 16; // num of tiles that make up the length and height

    protected String name;
    protected int[][] intMap;
    protected String[] dictionary;


    public ChunkTemplate() {}


    public String getName() {return name;}
    public int[][] getIntMap() {return intMap;}
    public String[] getDictionary() {return dictionary;}
}
