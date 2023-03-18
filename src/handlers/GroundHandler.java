package handlers;

import game.Game;
import models.Ground;

public record GroundHandler(Ground ground) {
    public void tick(BirdHandler birdHandler) {
        int newGroundX = ground.getX() + ground.getVelocityX();

        if (newGroundX + Game.WIDTH + 10 < 0) {
            newGroundX = 0;
        }

        ground.setX(newGroundX);

        if(birdHandler.bird().getY() + 12 >= ground.getY()) {
            birdHandler.die();
        }
    }
}
