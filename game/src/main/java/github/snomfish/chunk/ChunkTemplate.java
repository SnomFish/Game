package github.snomfish.chunk;

import github.snomfish.tile.Tile;

public class ChunkTemplate {
    
    public static int LENGTH = 8; // num of tiles that make up the length and height
    public static int SIZE = Tile.SIZE * LENGTH;
    public static int SIZE_Y = Tile.SIZE_Y * LENGTH;

    protected String name;
    protected String[] dictionary;
    protected int[][] intMap;
    protected int[][] heightMap;


    public ChunkTemplate() {}


    public String getName() {return name;}
    public String[] getDictionary() {return dictionary;}
    public int[][] getIntMap() {return intMap;}
    public int[][] getHeightMap() {return heightMap;}
}
