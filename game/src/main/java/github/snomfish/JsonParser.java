package github.snomfish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    

    private JsonParser() {}


    @SuppressWarnings("CallToPrintStackTrace")
    public static <T> T parse(String filePath, Class<T> clazz) {
        try {

            InputStream is = JsonParser.class.getResourceAsStream(filePath);

            if (is == null) throw new FileNotFoundException("file " + filePath + " not found.");

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(is, clazz);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @SuppressWarnings("CallToPrintStackTrace")
    public static <T> void write(String filePath, T object) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File(filePath), object);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("CallToPrintStackTrace")
    public static BufferedImage parseImage(String filePath) {
        try {
            
            InputStream is = JsonParser.class.getResourceAsStream(filePath);

            if (is == null) throw new FileNotFoundException("file " + filePath + " not found.");

            return ImageIO.read(is);
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
