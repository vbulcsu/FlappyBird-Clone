package handlers;

import models.Bird;

import java.awt.event.MouseEvent;

public record BirdHandler(Bird bird) {
    public void die() {
        bird.setAlive(false);
        SoundHandler.playSound("assets/audio/hit.wav", -20.0f);
        SoundHandler.playSound("assets/audio/die.wav", -15.0f);
    }

    public void flap() {
        bird.setVelocityY(-8);
        SoundHandler.playSound("assets/audio/wing.wav", -20.0f);
    }

    public void handleMouseEvent(MouseEvent e) {
        if (e.getButton() == 1) {
            flap();
        }
    }

    public void tick() {
        int velocity = bird.getVelocityY();

        bird.setY(bird.getY() + velocity);

        if (velocity < 10) {
            bird.setVelocityY(velocity + 1);
        }
    }
}
