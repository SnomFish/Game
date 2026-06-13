package github.snomfish.world;

import java.util.HashMap;

import github.snomfish.JsonParser;
import github.snomfish.chunk.ChunkInstance;
import github.snomfish.chunk.ChunkRegistry;

public class WorldRegistry {
    

    public static final String FOLDER_FILE_PATH = "/worlds/";


    public WorldRegistry() {}


    public static World generateNewWorld(String name) {
        World world = new World();
        world.setName(name); // SUCCEPTABLE TO INSERTION ATTACKS
        world.setChunkMap(new HashMap<>());
        System.out.println("test");

        for (int i = -3; i < 3; i ++) {
            for (int j = -3; j < 3; j ++) {
                ChunkInstance chunk = ChunkRegistry.newInstance("default");
                world.addChunk(i, j, chunk);
            }
        }

        return world;
    }


    public static World loadFromFile(String name) {
        String fileName = name + ".json";
        World world = JsonParser.parse(FOLDER_FILE_PATH + fileName, World.class);
        return world;
    }


    public static void saveToFile(World world) {
        String fileName = world + ".json";
        JsonParser.write(FOLDER_FILE_PATH + fileName, world);
    }
}
