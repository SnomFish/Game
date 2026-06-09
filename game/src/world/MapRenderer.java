package game.src.world;

import game.src.Camera;
import java.awt.Graphics2D;
import java.util.List;

public class MapRenderer {
    

    public void render(
        Graphics2D g2,
        Camera camera,
        TileManager tileManager,
        MapManager mapManager
    ) {
        Map map = mapManager.getCurrentMap();
        int[][] intMap = map.getIntMap();
        List<Tile> tiles = tileManager.getTiles();
        Tile tile;
        int size;
        for (int i = 0; i < intMap.length; i ++) {
            for (int j = 0; j < intMap[i].length; j ++) {
                tile = tiles.get(intMap[i][j]);
                size = (int) (tileManager.getOriginalSize() * camera.getScale());
                g2.drawImage(tile.getImage(), i*size, j*size, size, size, null);
            }
        }
    }
}
