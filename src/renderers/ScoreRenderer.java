package renderers;

import models.Score;

import java.awt.*;

public class ScoreRenderer implements ObjectRenderer {
    private final Score score;

    public ScoreRenderer(Score score) {
        this.score = score;
    }

    @Override
    public void render(Graphics g) {
        int x = score.getX();
        int y = score.getY();
        String text = String.valueOf(score.getScore());

        g.setFont(score.getFont());
        g.setColor(Color.WHITE);

        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();

        g.drawString(text, x - width / 2, y - height / 2);
    }
}
