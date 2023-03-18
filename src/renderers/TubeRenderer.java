package renderers;

import game.Game;
import models.Tube;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TubeRenderer implements ObjectRenderer {

    private final Tube tube;

    public TubeRenderer(Tube tube) {
        this.tube = tube;
    }

    @Override
    public void render(Graphics g) {
        BufferedImage[] images = tube.getSprites();
        int x = tube.getX();
        int y = tube.getY();
        int gapw = tube.getGapWidth();
        int gaph = tube.getGapHeight();

        g.drawImage(images[0], x, 0, x + gapw, y, 0, images[0].getHeight() - y, gapw,
                images[0].getHeight(), null);
        g.drawImage(images[1], x, y + gaph, x + gapw, Game.HEIGHT - 145, 0, 0, gapw,
                Game.HEIGHT - 145 - y - gaph, null);
    }
}
