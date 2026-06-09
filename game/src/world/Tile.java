package game.src.world;

import java.awt.image.BufferedImage;

public class Tile {
    

    private String name;
    private Boolean hasCollision;
    private BufferedImage image;


    // CONSTRUCTOR
    public Tile(
        String name,
        Boolean hasCollision,
        BufferedImage image
    ) {
        this.name = name;
        this.hasCollision = hasCollision;
        this.image = image;
    }


    // GETTERS
    public String getName() {return name;}
    public Boolean hasCollision() {return hasCollision;}
    public BufferedImage getImage() {return image;}


    // SETTERS
    public void setName(String name) {this.name = name;}
    public void setCollision(Boolean hasCollision) {this.hasCollision = hasCollision;}
    public void setImage(BufferedImage image) {this.image = image;}
}
