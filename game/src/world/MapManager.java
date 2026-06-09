package game.src.world;

import java.util.ArrayList;
import java.util.List;

import game.src.util.ResPath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MapManager {
    

    private List<Map> maps = new ArrayList<>();
    private Map currentMap;


    public MapManager() {
        loadMaps();
    }


    // GETTERS
    public List<Map> getMaps() {return maps;}
    public Map getCurrentMap() {return currentMap;}


    // SETTERS
    public void setMaps(List<Map> maps) {this.maps = maps;}
    public void setCurrentMap(Map currentMap) {this.currentMap = currentMap;}
    public void setCurrentMap(int i) {this.currentMap = maps.get(i);}


    public final void loadMaps() {
        try (InputStream is = getClass().getResourceAsStream(ResPath.MAPS + "/testMap.txt")) {
            maps.add(parseMap(new String(is.readAllBytes(), StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map parseMap(String textMap) {
        String[] lines = textMap.split("\n");
        String[][] stringMap = new String[lines.length][];
        for (int i = 0; i < lines.length; i ++) {
            stringMap[i] = lines[i].split(" ");
        }
        int[][] intMap = new int[stringMap.length][stringMap[0].length];
        for (int i = 0; i < stringMap.length; i ++) {
            for (int j = 0; j < stringMap[i].length; j ++) {
                intMap[i][j] = Integer.parseInt(stringMap[i][j].trim());
            }
        }

        Map map = new Map(intMap);

        return map;
    }
}
