package com.example.world;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.example.util.DefaultSize;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TileManager {
    

    private final String tileFolder = "/sprites/tiles/";
    private final String tileData = tileFolder + "tiles.json";
    private Map<String, Tile> tileMap = new HashMap<>();


    // CONSTRUCTOR
    public TileManager() {
        loadTiles();
    }


    // GETTER
    public Map<String, Tile> getTileMap() {return tileMap;}


    // SETTERS
    //


    public final void loadTiles() {
        try {
            InputStream is = getClass().getResourceAsStream(tileData);
            if (is == null) throw new FileNotFoundException("tileData not found");

            ObjectMapper mapper = new ObjectMapper();
            List<Tile> tiles = mapper.readValue(
                is.readAllBytes(),
                new TypeReference<List<Tile>>() {}
            );
            for (Tile tile : tiles) {
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream(tileFolder + tile.getImagePath()));
                tile.setImage(image);
                tileMap.put(tile.getName(), tile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean hasTile(String tileName) {return tileMap.containsKey(tileName);}
    public Tile getTile(String tileName) {
        if (!hasTile(tileName)) return tileMap.get("grass");
        return tileMap.get(tileName);
    }
}
