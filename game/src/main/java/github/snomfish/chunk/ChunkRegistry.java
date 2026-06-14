package github.snomfish.chunk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import github.snomfish.JsonParser;

public class ChunkRegistry {


    private static final String FOLDER_FILE_PATH = "/chunk/";
    private static final String LIST_FILE_PATH = FOLDER_FILE_PATH + "chunkList.json"; 
    private static final Map<String, ChunkTemplate> registry = new HashMap<>();


    private ChunkRegistry() {}


    static {
        load();
        System.out.println("loaded ChunkRegistry");
    }
    private static void load() {
        String[] filePathList = JsonParser.parse(LIST_FILE_PATH, String[].class);
        String name;
        int[][] intMap;
        String[] dictionary;

        for (String filePath : filePathList) {
            ChunkTemplate chunk = JsonParser.parse(FOLDER_FILE_PATH + filePath, ChunkTemplate.class);
            name = chunk.getName();
            intMap = chunk.getIntMap();
            dictionary = chunk.getDictionary();
            
            if (registry.containsKey(name)) throw new RuntimeException("Attempted to overwrite chunk with same name: " + name);
            if (intMap.length < ChunkTemplate.LENGTH) throw new RuntimeException("intMap for chunk " + name + " has too few cols (" + intMap.length + ")");
            if (!Arrays.stream(intMap).allMatch(a -> a.length >= ChunkTemplate.LENGTH)) throw new RuntimeException("intMap for chunk " + name + " has too few rows");
            
            registry.put(chunk.getName(), chunk);
            
        }
    }


    public static boolean isEmpty() {
        return registry.isEmpty();
    }
    public static boolean has(String key) {
        return registry.containsKey(key);
    }
    public static ChunkTemplate get(String key) {
        if (!has(key)) throw new RuntimeException("key " + key + " not found in chunk registry."); // maybe replace with returning the err chunk
        return registry.get(key);
    }
    public static ChunkInstance newInstance(String key) {
        ChunkTemplate template = get(key);
        return new ChunkInstance(template);
    }
}