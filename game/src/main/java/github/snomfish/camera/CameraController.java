package github.snomfish.camera;

import github.snomfish.entity.Player;

public class CameraController {
    

    private final Camera camera;


    public CameraController(
        Camera camera
    ) {
        this.camera = camera;
    }


    public void update(
        Player player
    ) {
        int playerWorldPosX = player.getWorldPosX();
        int playerWorldPosY = player.getWorldPosY();
        setCameraPos(playerWorldPosX, playerWorldPosY);
    }


    public void setCameraPos(int x, int y) {
        camera.setWorldPosX(x);
        camera.setWorldPosY(y);
    }
}
