package github.snomfish.camera;

import github.snomfish.GamePanel;
import github.snomfish.KeyHandler;
import github.snomfish.chunk.ChunkTemplate;
import github.snomfish.entity.Player;
import github.snomfish.number.Vector3;
import github.snomfish.tile.Tile;

public class Camera {
    
    
    private double scale = 1;
    private int renderDistance = 1;
    private Vector3 pos; // REAL POSITION
    private int worldPosX;
    private int worldPosY;

    private final KeyHandler keyHandler;


    public Camera(
        KeyHandler keyHandler
    ) {
        this.pos = Vector3.zero();
        this.keyHandler = keyHandler;
    }



    public Vector3 getPos() {return pos;} // the actual posiiton of hte object
    public Vector3 getRenderPos() {return new Vector3(
        pos.getX() - (GamePanel.SCREEN_WIDTH / (2*scale)),
        pos.getY() - (GamePanel.SCREEN_HEIGHT / (2*scale)),
        pos.getZ());
    } // the position that should exist on the screen
    public Vector3 getTilePos() {return pos.div(Tile.SIZE).floor();}
    public Vector3 getChunkPos() {return pos.div(ChunkTemplate.SIZE).floor();}


    public double getScale() {return scale;}
    public int getRenderDistance() {return renderDistance;}
    public int getWorldPosX() {return worldPosX;}
    public int getWorldPosY() {return worldPosY;}
    public int getTilePosX() {return (int) Math.floor((double) worldPosX / Tile.SIZE);}
    public int getTilePosY() {return (int) Math.floor((double) worldPosY / Tile.SIZE);}
    public int getChunkPosX() {return (int) Math.floor((double) worldPosX / ChunkTemplate.SIZE);}
    public int getChunkPosY() {return (int) Math.floor((double) worldPosY / ChunkTemplate.SIZE);}
    public int getRenderPosX() {return (int) (worldPosX - (GamePanel.SCREEN_WIDTH / (2*scale)));}
    public int getRenderPosY() {return (int) (worldPosY - (GamePanel.SCREEN_HEIGHT / (2*scale)));}   


    public void setScale(double scale) {this.scale = scale;}
    public void setRenderDistance(int renderDistance) {this.renderDistance = renderDistance;}
    public void setWorldPosX(int worldPosX) {this.worldPosX = worldPosX;}
    public void setWorldPosY(int worldPosY) {this.worldPosY = worldPosY;}


    public int getScreenSizeX(int objWorldSizeX) {return (int) (objWorldSizeX * scale);}
    public int getScreenSizeY(int objWorldSizeY) {return (int) (objWorldSizeY * scale);}
}
