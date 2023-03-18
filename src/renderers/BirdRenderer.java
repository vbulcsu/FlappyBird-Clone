package renderers;

import models.Bird;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BirdRenderer implements ObjectRenderer {

    private final Bird bird;

    public BirdRenderer(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void render(Graphics g) {
        int x = bird.getX() - 17;
        int y = bird.getY() - 12;
        BufferedImage image = bird.getNextSprite();

        g.drawImage(image, x, y, null);
    }
}
