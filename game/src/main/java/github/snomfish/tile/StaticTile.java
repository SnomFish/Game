package github.snomfish.tile;

import java.awt.image.BufferedImage;

import github.snomfish.JsonParser;

public class StaticTile extends Tile {
 

    private final BufferedImage image;


    public StaticTile(
        String name,
        String imagePath
    ) {
        this.name = name;
        this.image = JsonParser.parseImage(TileRegistry.FOLDER_FILE_PATH + imagePath);
    }

    
    @Override
    public BufferedImage getImage(int x, int y) {return image;}
}
