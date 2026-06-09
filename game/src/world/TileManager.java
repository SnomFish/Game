package game.src.world;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.src.util.ResPath;

public class TileManager {
    

    private List<Tile> tiles = new ArrayList<>();
    private final int originalSize = 16;


    // CONSTRUCTOR
    public TileManager() {
        loadTiles();
    }


    // GETTER
    public List<Tile> getTiles() {return tiles;}
    public int getOriginalSize() {return originalSize;}


    // SETTERS
    public void setTiles(List<Tile> tiles) {this.tiles = tiles;}
    //public void setOriginalSize() immutable


    public final void loadTiles() {
        try {
            tiles.add(new Tile("grass", false,  ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_grass_1.png"))));
            tiles.add(new Tile("dirt", false,   ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_dirt_1.png"))));
            tiles.add(new Tile("sand", false,   ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_sand_1.png"))));
            tiles.add(new Tile("water", false,  ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_water_1.png"))));
            tiles.add(new Tile("tree", false,   ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_tree_1.png"))));
            tiles.add(new Tile("brick", false,  ImageIO.read(getClass().getResourceAsStream(ResPath.SPRITES + "/tiles/tile_brick_1.png"))));
        } catch (IOException e) {}
    }
}
