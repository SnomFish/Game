package github.snomfish.tile;

public class TileDef {
    

    private String name;
    private String imagePath;
    private String type;


    public TileDef() {}


    public String getName() {return name;}
    public String getImagePath() {return imagePath;}
    public String getType() {return type;}

    public void setName(String name) {this.name = name;}
    public void setImagePath(String imagePath) {this.imagePath = imagePath;}
    public void setType(String type) {this.type = type;}


    public Tile toTile() {
        Tile tile;

        if (type.equals("random")) {
            tile = new RandomTile(name, imagePath);
        } else {
            tile = new StaticTile(name, imagePath);
        }

        return tile;
    }
}
