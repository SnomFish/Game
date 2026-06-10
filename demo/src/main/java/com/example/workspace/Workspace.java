package com.example.workspace;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.example.KeyHandler;
import com.example.MouseHandler;
import com.example.entity.Entity;
import com.example.entity.Player;
import com.example.number.Vector3;
import com.example.world.MapManager;
import com.example.world.MapRenderer;
import com.example.world.TileManager;

public class Workspace {
    
    
    private final Vector3 defaultCameraPos = Vector3.zero();
    private final Vector3 defaultPlayerPos = Vector3.zero();

    private List<Entity> entities;
    private Player player;
    private Camera camera;
    private TileManager tileManager;
    private MapManager mapManager;
    private MapRenderer mapRenderer;


    // CONSTRUCTORS
    public Workspace(
        KeyHandler keyH,
        MouseHandler mouseH
    ) {
        this.entities = new ArrayList<>();
        this.player = new Player(defaultPlayerPos, keyH);
        this.camera = new Camera(defaultCameraPos);
        this.tileManager = new TileManager();
        this.mapManager = new MapManager();
        this.mapRenderer = new MapRenderer();

        entities.add(player);
    }

    
    // GETTERS
    public List<Entity> getEntites() {return entities;}
    public Player getPlayer() {return player;}
    public Camera getCamera() {return camera;}
    public TileManager getTileManager() {return tileManager;}
    public MapManager getMapManager() {return mapManager;}
    public MapRenderer getMapRenderer() {return mapRenderer;}


    // SETTERS
    public void setEntities(List<Entity> entities) {this.entities = entities;} 
    public void setPlayer(Player player) {this.player = player;}
    public void setCamera(Camera camera) {this.camera = camera;}
    public void setTileManager(TileManager tileManager) {this.tileManager = tileManager;}
    public void setMapManager(MapManager mapManager) {this.mapManager = mapManager;}
    public void setMapRenderer(MapRenderer mapRenderer) {this.mapRenderer = mapRenderer;}


    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
        camera.update(player.getPos(), mapManager.getMap());
    }


    public void render(Graphics2D g2) {
        mapRenderer.render(g2, camera, tileManager, mapManager);
        for (Entity entity : entities) {
            entity.render(g2, camera);
        }
    }
    

    public void addEntity(Entity entity) {entities.add(entity);}
    public void removeEntity(Entity entity) {entities.remove(entity);}
    public boolean hasEntity(Entity entity) {return entities.contains(entity);}
}
