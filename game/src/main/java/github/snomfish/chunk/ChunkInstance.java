package github.snomfish.chunk;

import java.util.Arrays;

import github.snomfish.number.Vector3;

public class ChunkInstance extends ChunkTemplate {


    private Vector3 pos;

    
    public ChunkInstance(
        ChunkTemplate template
    ) {
        this.name = template.name;
        this.intMap = Arrays.stream(template.intMap)
            .map(int[]::clone)
            .toArray(int[][]::new);
        this.dictionary = template.dictionary.clone();
    }


    public Vector3 getPos() {return pos;}


    public void setPos(Vector3 pos) {this.pos = pos;}
    public void setPos(int x, int y) {
        pos = new Vector3( // converts a chunks [x][y] to actual pos
            x * ChunkTemplate.SIZE,
            y * ChunkTemplate.SIZE,
            0
        );
    }
}
