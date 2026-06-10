package com.example.world;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapManager {
    

    private final String mapFolder = "/maps/";
    private final String defaultMap = "defaultMap.json";
    private GameMap map;


    public MapManager() {
        setMap(defaultMap);
    }


    // GETTERS
    public GameMap getMap() {
        if (map == null) setMap(defaultMap);
        return map;
    }


    public void setMap(String fileName) {
        try {
            String path = mapFolder + fileName;

            InputStream is = getClass().getResourceAsStream(path);
            if (is == null) throw new FileNotFoundException("Map not found: " + path);

            String mapString = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(mapString, GameMap.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
