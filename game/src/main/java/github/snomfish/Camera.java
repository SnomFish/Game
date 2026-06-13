package github.snomfish;

import github.snomfish.chunk.ChunkTemplate;
import github.snomfish.entity.Player;
import github.snomfish.number.Vector3;
import github.snomfish.tile.Tile;

public class Camera {
    
    
    private double scale = 4;
    private final int renderDistance = 1;
    private Vector3 pos; // REAL POSITION

    private final KeyHandler keyHandler;


    public Camera(
        Vector3 pos,
        KeyHandler keyHandler
    ) {
        this.pos = pos;
        this.keyHandler = keyHandler;
    }


    public double getScale() {return scale;}
    public int getRenderDistance() {return renderDistance;}
    public void setScale(double scale) {this.scale = scale;}

    public Vector3 getPos() {return pos;} // the actual posiiton of hte object
    public Vector3 getRenderPos() {return new Vector3(
        pos.getX() - (GamePanel.SCREEN_WIDTH / (2*scale)),
        pos.getY() - (GamePanel.SCREEN_HEIGHT / (2*scale)),
        pos.getZ());
    } // the position that should exist on the screen
    public Vector3 getTilePos() {return pos.div(Tile.SIZE).floor();}
    public Vector3 getChunkPos() {return pos.div(ChunkTemplate.SIZE).floor();}


    public void update(Player player) {
        pos = player.getPos();

        if (keyHandler.plusPressed()) {
            scale += 0.1;
        } else if (keyHandler.minusPressed()) {
            scale -= 0.1;
        }
        scale = Math.min(scale, 6);
        scale = Math.max(scale, 1);
    }

    
}
