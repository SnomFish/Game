package game.src.world;

public class Map {
    

    private int intMap[][];


    // CONSTRUCTOR
    public Map(int[][] intMap) {this.intMap = intMap;}


    // GETTERS
    public int[][] getIntMap() {return intMap;}


    // SETTERS
    @SuppressWarnings("unused")
    public void setIntMap(int[][] intMap) {this.intMap = intMap;}
}
