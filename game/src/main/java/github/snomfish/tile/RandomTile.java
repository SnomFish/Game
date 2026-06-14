package github.snomfish.tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import github.snomfish.Direction;
import github.snomfish.JsonParser;
import github.snomfish.Renderer;

public class RandomTile extends Tile{
    

    private final List<BufferedImage> images = new ArrayList<>();


    public RandomTile(
        String name,
        String imagePath
    ) {
        this.name = name;
        
        BufferedImage image = JsonParser.parseImage(TileRegistry.FOLDER_FILE_PATH + imagePath);
        for (Direction dir : Direction.values()) {
            images.add(Renderer.rotate(image, dir));
        }
    }


    public List<BufferedImage> getImages() {return images;}
    @Override
    public BufferedImage getImage(int x, int y) { // tile pos
        return images.get((x + y) % images.size());
    }
}
