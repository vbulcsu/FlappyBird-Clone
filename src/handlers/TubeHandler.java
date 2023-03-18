package handlers;

import game.Game;
import models.Bird;
import models.Score;
import models.Tube;

import java.util.Random;

public class TubeHandler {
    private final Tube tube;
    private final Random random;

    public TubeHandler(Tube tube) {
        this.tube = tube;
        random = new Random();
    }

    public void tick(BirdHandler birdHandler, Score score) {
        Bird bird = birdHandler.bird();

        int newTubeX = tube.getX() + tube.getVelocityX();
        int tubeY = tube.getY();

        if(newTubeX + tube.getGapWidth() < 0) {
            newTubeX = Game.WIDTH;
            tubeY = random.nextInt(25, Game.HEIGHT - 300);
            tube.setY(tubeY);
            tube.setScored(false);
        }

        tube.setX(newTubeX);

        int birdX = bird.getX();
        int birdY = bird.getY();

        if(birdX + 17 > newTubeX && birdX - 17 < newTubeX + tube.getGapWidth()
            && (birdY - 12 < tubeY || birdY + 12 > tubeY + tube.getGapHeight())) {

            birdHandler.die();
        }

        if(birdX - 17 >= newTubeX + tube.getGapWidth() && !tube.isScored()) {
            tube.setScored(true);
            score.incrementScore();
            SoundHandler.playSound("assets/audio/point.wav", -15.0f);
        }
    }
}
