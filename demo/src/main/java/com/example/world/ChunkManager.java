package com.example.world;

import java.util.HashMap;
import java.util.Map;

public class ChunkManager {


    private Map<Integer, Map<Integer, Chunk>> chunks;

    
    public ChunkManager() {
        chunks = new HashMap<>();
    }


    public Map<Integer, Map<Integer, Chunk>> getChunks() {return chunks;}


    public boolean chunksInitiated() {return chunks.isEmpty();}
    public boolean chunkRowInitiated(int x) {return chunks.get(x).isEmpty();}
    public boolean isChunkPopulated(int x, int y) {
        if (!chunkRowInitiated(x)) return false;
        return chunks.get(x).get(y) != null;
    }
    public Chunk getChunk(int x, int y) {
        if (!isChunkPopulated(x, y)) throw new RuntimeException("Chunk not found at " + x + ", " + y);
        return chunks.get(x).get(y);
    }
    public void addChunk(int x, int y, Chunk chunk) {
        if (isChunkPopulated(x, y)) throw new RuntimeException("Attempting to override a chunk.");
        chunks.get(x).put(y, chunk);
    } 
}
