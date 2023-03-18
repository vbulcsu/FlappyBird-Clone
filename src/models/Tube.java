package models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tube extends GameObject {

    private final int gapWidth;
    private final int gapHeight;
    private final BufferedImage[] sprites;
    private boolean scored;

    public Tube(int x, int y) {
        super(x, y);

        gapWidth = 52;
        gapHeight = 104;
        velocityX = -2;

        scored = false;

        sprites = new BufferedImage[2];

        try {
            sprites[0] = ImageIO.read(new File("assets/sprites/pipe-green-down.png"));
            sprites[1] = ImageIO.read(new File("assets/sprites/pipe-green-up.png"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage[] getSprites() {
        return sprites;
    }

    public int getGapWidth() {
        return gapWidth;
    }

    public int getGapHeight() {
        return gapHeight;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }
}
