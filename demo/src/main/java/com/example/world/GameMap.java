package com.example.world;

import com.example.number.Vector3;

public class GameMap {
    

    private int intMap[][];
    private String dictionary[];


    // CONSTRUCTOR
    public GameMap() {}


    // GETTERS
    public int[][] getIntMap() {return intMap;}
    public String[] getDictionary() {return dictionary;}


    // SETTERS
    public void setIntMap(int[][] intMap) {this.intMap = intMap;}
    public void setDictionary(String[] dictionary) {this.dictionary = dictionary;}


    
    public boolean indexInRange(int i) {
        return (i >= 0) && (i < dictionary.length);
    }
    public String getTileName(int index) {
        if (!indexInRange(index)) return "grass";
        return dictionary[index];
    }
    public String getTileName(int i, int j) {
        int index = intMap[i][j];
        return getTileName(index);
    }


    // will take in position and return the closest tile
    public Vector3 findClosestTile(Vector3 pos) {
        double x = (int)Math.clamp(pos.getX(), 0, intMap[0].length);
        double y = (int)Math.clamp(pos.getY(), 0, intMap.length);
        return new Vector3(x, y, 0.0);
    }
}
