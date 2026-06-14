package github.snomfish;

import github.snomfish.camera.Camera;
import github.snomfish.camera.CameraController;
import github.snomfish.entity.Player;
import github.snomfish.world.World;
import github.snomfish.world.WorldRegistry;

public class Workspace {
    

    private final CameraController cameraController;
    private final World world;
    private final Player player;


    public Workspace(
        Camera camera,
        KeyHandler keyH,
        MouseHandler mouseH
    ) {
        this.world = WorldRegistry.generateNewWorld("test_world");
        this.cameraController = new CameraController(camera);
        this.player = new Player(keyH, mouseH);

        
    }


    public World getWorld() {return world;}


    public void update() {
        player.update();
        cameraController.update(player);
    }


    public void render(Renderer renderer) {
        renderer.renderWorld(world);
        player.render(renderer);
    }
}
