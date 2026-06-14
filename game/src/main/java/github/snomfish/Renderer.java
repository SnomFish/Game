package github.snomfish;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import github.snomfish.camera.Camera;
import github.snomfish.chunk.ChunkInstance;
import github.snomfish.chunk.ChunkTemplate;
import github.snomfish.tile.Tile;
import github.snomfish.tile.TileRegistry;
import github.snomfish.world.World;

public class Renderer {


    private Camera camera;
    private Graphics2D g2;


    public Renderer(
        Camera camera
    ) {
        this.camera = camera;
    }


    public void setCamera(Camera camera) {this.camera = camera;}
    public void setGraphics2D(Graphics2D g2) {this.g2 = g2;}


    public void render(
        BufferedImage image, 
        int worldPosX,
        int worldPosY,
        int worldSizeX, 
        int worldSizeY
    ) {
        double scale = camera.getScale();
        int cameraRenderPosX = camera.getRenderPosX();
        int cameraRenderPosY = camera.getRenderPosY();
        int screenPosX = (int) ((worldPosX - (worldSizeX / 2) - cameraRenderPosX) * scale);
        int screenPosY = (int) ((worldPosY - (worldSizeY / 2) - cameraRenderPosY) * scale);
        int screenSizeX = (int) (worldSizeX * scale);
        int screenSizeY = (int) (worldSizeY * scale);
        g2.drawImage(
            image,
            screenPosX,
            screenPosY,
            screenSizeX,
            screenSizeY,
            null
        );
    }


    public void renderWorld(
        World world
    ) {
        int renderDistance = camera.getRenderDistance();
        double scale = camera.getScale();
        int cameraChunkPosX = camera.getChunkPosX();
        int cameraChunkPosY = camera.getChunkPosY();
        int cameraRenderPosX = camera.getRenderPosX();
        int cameraRenderPosY = camera.getRenderPosY();

        List<ChunkInstance> renderList = new ArrayList<>();

        int chunkRenderMinX = cameraChunkPosX - renderDistance;
        int chunkRenderMaxX = cameraChunkPosX + renderDistance;
        int chunkRenderMinY = cameraChunkPosY - renderDistance;
        int chunkRenderMaxY = cameraChunkPosY + renderDistance;

        System.out.println(cameraChunkPosX + ", " + cameraChunkPosY + " - " + camera.getWorldPosX() + ", " + camera.getWorldPosY());

        for (int i = chunkRenderMinX; i <= chunkRenderMaxX; i++) {
            for (int j = chunkRenderMinY; j <= chunkRenderMaxY; j ++) {
                ChunkInstance chunk = world.get(i, j);
                if (chunk != null) renderList.add(chunk);
            }
        }

        int[][] intMap;
        String[] dictionary;
        String tileName;
        Tile tile;
        BufferedImage image;

        int chunkPosX;
        int chunkPosY;

        int screenPosX;
        int screenPosY;
        int screenSizeX;
        int screenSizeY;

        for (ChunkInstance chunk : renderList) {

            intMap = chunk.getIntMap();
            dictionary = chunk.getDictionary();
            chunkPosX = chunk.getWorldPosX();
            chunkPosY = chunk.getWorldPosY();

            for (int i = 0; i < ChunkTemplate.LENGTH; i ++) {
                for (int j = 0; j < ChunkTemplate.LENGTH; j ++) {
                    tileName = dictionary[intMap[i][j]];
                    tile = TileRegistry.get(tileName);
                    image = tile.getImage(i, j);
                    screenPosX = (int) ((j * Tile.SIZE + chunkPosX - cameraRenderPosX) * scale);
                    screenPosY = (int) ((i * Tile.SIZE + chunkPosY - cameraRenderPosY) * scale);
                    screenSizeX = (int) (Tile.SIZE * scale);
                    screenSizeY = (int) (Tile.SIZE * scale);
                    g2.drawImage(
                        image,
                        screenPosX,
                        screenPosY,
                        screenSizeX,
                        screenSizeY,
                        null
                    );
                }
            }
        }
    }
    











    public static BufferedImage rotate(BufferedImage in, Direction dir) {

        int width = (dir == Direction.NORTH || dir == Direction.SOUTH) ? in.getWidth() : in.getHeight();
        int height = (dir == Direction.NORTH || dir == Direction.SOUTH) ? in.getHeight() : in.getWidth();

        BufferedImage out = new BufferedImage(width, height, in.getType());

        switch (dir) {

            case NORTH -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(x, y, in.getRGB(x, y));
                    }
                }
            }

            case EAST -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(height - 1 - y, x, in.getRGB(x, y));
                    }
                }
            }

            case SOUTH -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(width - 1 - x, height - 1 - y, in.getRGB(x, y));

                    }
                }
            }

            case WEST -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(y, width - 1 - x, in.getRGB(x, y));
                    }
                }
            }
        }

        return out;
    }
}
