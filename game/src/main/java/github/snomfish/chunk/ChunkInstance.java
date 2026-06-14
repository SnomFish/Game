package github.snomfish.chunk;

import java.util.Arrays;

import github.snomfish.number.Vector3;
import github.snomfish.tile.Tile;

public class ChunkInstance extends ChunkTemplate {


    private Vector3 pos;
    private int worldPosX;
    private int worldPosY;

    
    public ChunkInstance(
        ChunkTemplate template
    ) {
        this.name = template.name;
        this.dictionary = template.dictionary.clone();
        this.intMap = Arrays.stream(template.intMap)
            .map(int[]::clone)
            .toArray(int[][]::new);
        
        if (template.heightMap == null) {
            this.heightMap = new int[ChunkTemplate.LENGTH][ChunkTemplate.LENGTH];
        } else {
            this.heightMap = Arrays.stream(template.heightMap)
                .map(int[]::clone)
                .toArray(int[][]::new);
        }
        
    }


    public Vector3 getPos() {return pos;}
    public int getWorldPosX() {return worldPosX;}
    public int getWorldPosY() {return worldPosY;}


    public void setPos(Vector3 pos) {this.pos = pos;}
    public void setPos(int x, int y) {
        this.worldPosX = x * ChunkInstance.SIZE;
        this.worldPosY = y * ChunkInstance.SIZE;
    }
}
