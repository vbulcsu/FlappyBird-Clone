package models;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Score extends GameObject {

    private final Font font;
    private int score;

    public Score(int x, int y) {
        super(x, y);

        score = 0;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/Flappy-Bird.ttf")).deriveFont(45.0f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Font getFont() {
        return font;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        score++;
    }
}
