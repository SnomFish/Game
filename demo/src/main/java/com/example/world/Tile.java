package com.example.world;

import java.awt.image.BufferedImage;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tile {
    

    private String name;
    private boolean hasCollision;
    private String imagePath;
    @JsonIgnore
    private BufferedImage image;


    // CONSTRUCTOR
    public Tile() {
    }


    // GETTERS
    public String getName() {return name;}
    public Boolean hasCollision() {return hasCollision;}
    public String getImagePath() {return imagePath;}
    public BufferedImage getImage() {return image;}


    // SETTERS
    public void setName(String name) {this.name = name;}
    public void setHasCollision(Boolean hasCollision) {this.hasCollision = hasCollision;}
    public void setImagePath(String imagePath) {this.imagePath = imagePath;}
    public void setImage(BufferedImage image) {this.image = image;}
}
