package models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends GameObject {
    private final BufferedImage[] sprites;
    private int animationIndex;
    private boolean isAlive;

    public Bird(int x, int y) {
        super(x, y);

        velocityY = 5;

        sprites = new BufferedImage[3];
        animationIndex = 0;
        isAlive = true;

        try {
            sprites[0] = ImageIO.read(new File("assets/sprites/yellowbird-upflap.png"));
            sprites[1] = ImageIO.read(new File("assets/sprites/yellowbird-midflap.png"));
            sprites[2] = ImageIO.read(new File("assets/sprites/yellowbird-downflap.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getNextSprite() {
        int oldAnimationIndex = animationIndex;
        animationIndex++;

        if(animationIndex >= sprites.length) {
            animationIndex = 0;
        }

        return sprites[oldAnimationIndex];
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
