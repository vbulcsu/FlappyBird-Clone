package models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground extends GameObject {

    private final BufferedImage sprite;

    public Ground(int x, int y) {
        super(x, y);

        velocityX = -2;

        try {
            sprite = ImageIO.read(new File("assets/sprites/base.png"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
