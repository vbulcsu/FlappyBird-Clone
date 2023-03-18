package renderers;

import game.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameRenderer extends JPanel {
    private final ObjectRenderer[] objects;
    private final BufferedImage background;
    private final BufferedImage startscreen;
    private final BufferedImage gameover;
    private boolean started;
    private boolean finished;

    public GameRenderer(ObjectRenderer[] objects) {
        this.objects = objects;

        started = false;
        finished = false;

        try {
            background = ImageIO.read(new File("assets/sprites/background-day.png"));
            startscreen = ImageIO.read(new File("assets/sprites/message.png"));
            gameover = ImageIO.read(new File("assets/sprites/gameover.png"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);

        for (ObjectRenderer object : objects) {
            object.render(g);
        }

        if(!started) {
            int x = Game.WIDTH / 2 - startscreen.getWidth() / 2;
            int y = Game.HEIGHT / 2 - startscreen.getHeight() / 2;

            g.drawImage(startscreen, x, y - 75, null);
        }

        if(finished) {
            int x = Game.WIDTH / 2 - gameover.getWidth() / 2;
            int y = Game.HEIGHT / 2 - gameover.getHeight() / 2;

            g.drawImage(gameover, x, y - 75, null);
        }
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
