package github.snomfish.world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.snomfish.Camera;
import github.snomfish.chunk.ChunkInstance;
import github.snomfish.chunk.ChunkTemplate;
import github.snomfish.number.Vector3;
import github.snomfish.tile.Tile;
import github.snomfish.tile.TileRegistry;

public class World {
    

    private String name;
    private Map<Integer, Map<Integer, ChunkInstance>> chunkMap;


    public World() {}


    public String getName() {return name;}
    public Map<Integer, Map<Integer, ChunkInstance>> getChunkMap() {return chunkMap;}

    public void setName(String name) {this.name = name;}
    public void setChunkMap(Map<Integer, Map<Integer, ChunkInstance>> chunkMap) {this.chunkMap = chunkMap;}


    public boolean has(int x, int y) {
        if (chunkMap.get(x) == null) return false;
        return chunkMap.get(x).get(y) != null;
    }
    public ChunkInstance get(int x, int y) {
        if (!has(x, y)) return null;
        return chunkMap.get(x).get(y);
    }
    public void overwriteChunk(int x, int y, ChunkInstance chunkInstance) {
        if (chunkMap.get(x) == null) chunkMap.put(x, new HashMap<>());
        chunkMap.get(x).put(y, chunkInstance);
        chunkInstance.setPos(x, y);
    }
    public void addChunk(int x, int y, ChunkInstance chunkInstance) {
        // checks that the chunk spot is not already populated before adding the chunk
        if (has(x, y)) throw new RuntimeException("Chunk at (" + x + ", " + y + ") is already taken");
        overwriteChunk(x, y, chunkInstance); // overwrite has the same functionality but without the check
    }


    public void render(
        Graphics2D g2, 
        Camera camera
    ) {
        Vector3 cameraChunkPos = camera.getChunkPos();

        int cameraChunkX = cameraChunkPos.getIntX();
        int cameraChunkY = cameraChunkPos.getIntY();

        List<ChunkInstance> renderList = new ArrayList<>();
        int renderDistance = camera.getRenderDistance();
        for (int i = (cameraChunkX - renderDistance); i <= (cameraChunkX + renderDistance); i++) {
            for (int j = (cameraChunkY - renderDistance); j <= (cameraChunkY + renderDistance); j++) {
                renderList.add(get(i, j));
            }
        }

        for (ChunkInstance chunkInstance : renderList) {
            if (chunkInstance != null) {
                renderChunk(g2, camera, chunkInstance);
            }
        }
    }

    public void renderChunk(
        Graphics2D g2,
        Camera camera,
        ChunkInstance chunkInstance
    ) {
        Vector3 cameraRenderPos = camera.getRenderPos();
        int cameraRenderX = cameraRenderPos.getIntX();
        int cameraRenderY = cameraRenderPos.getIntY();
        
        double scale = camera.getScale();

        Vector3 chunkPos = chunkInstance.getPos();
        int[][] intMap = chunkInstance.getIntMap();
        String[] dictionary = chunkInstance.getDictionary();
        String tileName;
        Tile tile;
        BufferedImage image;
        int screenX;
        int screenY;
        int screenSize;

        for (int i = 0; i < ChunkTemplate.LENGTH; i ++) {
            for (int j = 0; j < ChunkTemplate.LENGTH; j ++) {
                tileName = dictionary[intMap[i][j]];
                tile = TileRegistry.get(tileName);
                image = tile.getImage(i, j);
                screenX = (int) ((chunkPos.getX() + (j * Tile.SIZE) - cameraRenderX) * scale);
                screenY = (int) ((chunkPos.getY() + (i * Tile.SIZE) - cameraRenderY) * scale);
                screenSize = (int) (Tile.SIZE * scale);
                g2.drawImage(
                    image,
                    screenX,
                    screenY,
                    screenSize,
                    screenSize,
                    null
                );
            }
        }
    }
    
}
