package github.snomfish;

import java.awt.image.BufferedImage;

public class Render {
    

    public static BufferedImage rotate(BufferedImage in, Direction dir) {

        int width = (dir == Direction.NORTH || dir == Direction.SOUTH) ? in.getWidth() : in.getHeight();
        int height = (dir == Direction.NORTH || dir == Direction.SOUTH) ? in.getHeight() : in.getWidth();

        BufferedImage out = new BufferedImage(width, height, in.getType());

        switch (dir) {

            case NORTH -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(x, y, in.getRGB(x, y));
                    }
                }
            }

            case EAST -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(height - 1 - y, x, in.getRGB(x, y));
                    }
                }
            }

            case SOUTH -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(width - 1 - x, height - 1 - y, in.getRGB(x, y));

                    }
                }
            }

            case WEST -> {
                for (int x = 0; x < width; x ++) {
                    for (int y = 0; y < height; y ++) {
                        out.setRGB(y, width - 1 - x, in.getRGB(x, y));
                    }
                }
            }
        }

        return out;
    }
}
