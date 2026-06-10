package com.example.world;

import java.awt.Graphics2D;
import java.util.List;

import com.example.number.Vector3;
import com.example.util.DefaultSize;
import com.example.workspace.Camera;

public class MapRenderer {
    

    public void render(
        Graphics2D g2,
        Camera camera,
        TileManager tileManager,
        MapManager mapManager
    ) {
        GameMap map = mapManager.getMap();
        int[][] intMap = map.getIntMap();
        
        Tile tile;
        Vector3 cameraPos = camera.getPos(); 
        double scale = camera.getScale();
        double size;
        double screenX;
        double screenY;

        for (int i = 0; i < intMap.length; i ++) {
            for (int j = 0; j < intMap[i].length; j ++) {

                tile = tileManager.getTile(map.getTileName(i, j));
                size = DefaultSize.TILE;
                screenX = ((i - 0.5) * size) - cameraPos.getX();
                screenY = ((j - 0.5) * size) - cameraPos.getY();

                g2.drawImage(
                    tile.getImage(), 
                    (int)(screenX * scale), 
                    (int)(screenY * scale), 
                    (int)(size * scale), 
                    (int)(size * scale),
                    null
                );

            }
        }
    }
}
