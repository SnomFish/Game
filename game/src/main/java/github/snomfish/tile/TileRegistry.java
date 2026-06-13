package github.snomfish.tile;

import java.util.HashMap;
import java.util.Map;

import github.snomfish.JsonParser;

public class TileRegistry {
    

    public static final String FOLDER_FILE_PATH = "/tile/";
    public static final String LIST_FILE_PATH = FOLDER_FILE_PATH + "tileList.json"; 
    private static final Map<String, Tile> registry = new HashMap<>();


    private TileRegistry() {}


    static {
        load();
        System.out.println("loaded TileRegistry");
    }
    private static void load() {
        TileDef[] tiles = JsonParser.parse(LIST_FILE_PATH, TileDef[].class);

        for (TileDef tileDef : tiles) {
            registry.put(tileDef.getName(), tileDef.toTile());
        }
    }


    public static boolean isEmpty() {
        return registry.isEmpty();
    }
    public static boolean has(String key) {
        return registry.containsKey(key);
    }
    public static Tile get(String key) {
        if (!has(key)) return null;
        return registry.get(key);
    }
}
