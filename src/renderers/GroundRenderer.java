package renderers;

import game.Game;
import models.Ground;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GroundRenderer implements ObjectRenderer {
    private final Ground ground;

    public GroundRenderer(Ground ground) {
        this.ground = ground;
    }

    @Override
    public void render(Graphics g) {
        int x = ground.getX();
        int y = ground.getY();
        BufferedImage image = ground.getSprite();

        g.drawImage(image, x, y, null);
        g.drawImage(image, x + Game.WIDTH - 10, y, null);
    }
}
