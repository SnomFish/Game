package github.snomfish;

import java.awt.Graphics2D;

import github.snomfish.entity.Player;
import github.snomfish.number.Vector3;
import github.snomfish.world.World;
import github.snomfish.world.WorldRegistry;

public class Workspace {
    

    private final Vector3 defaultCameraPos = Vector3.zero();
    private final Vector3 defaultPlayerPos = Vector3.zero();

    private final World world;
    private final Camera camera;
    private final Player player;


    public Workspace(
        KeyHandler keyH,
        MouseHandler mouseH
    ) {
        world = WorldRegistry.generateNewWorld("test_world");
        camera = new Camera(defaultCameraPos, keyH);
        player = new Player(defaultPlayerPos, keyH);

        
    }


    public World getWorld() {return world;}


    public void update() {
        player.update();
        camera.update(player);
    }


    public void render(Graphics2D g2) {
        world.render(g2, camera);
        player.render(g2, camera);
    }
}
