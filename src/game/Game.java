package game;

import handlers.*;
import models.*;
import renderers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame implements ActionListener {

    public static int WIDTH = 300, HEIGHT = 550;
    private final Timer timer;
    private final Bird bird;
    private final Tube tube1;
    private final Tube tube2;

    private final Score score;
    private final GameRenderer gameRenderer;
    private final BirdHandler birdHandler;
    private final TubeHandler tubeHandler1;
    private final TubeHandler tubeHandler2;
    private final GroundHandler groundHandler;

    public Game(int x, int y) {
        int fps = 40;
        int delay = 1000 / fps;

        timer = new Timer(delay, this);

        this.setBounds(x, y, WIDTH, HEIGHT);

        bird = new Bird(100, 200);
        tube1 = new Tube(WIDTH, 150);
        tube2 = new Tube(WIDTH + 175, 100);
        score = new Score(WIDTH / 2, 50);
        Ground ground = new Ground(0, HEIGHT - 145);

        ObjectRenderer[] objectRenderers = new ObjectRenderer[5];
        objectRenderers[0] = new GroundRenderer(ground);
        objectRenderers[1] = new BirdRenderer(bird);
        objectRenderers[2] = new TubeRenderer(tube1);
        objectRenderers[3] = new TubeRenderer(tube2);
        objectRenderers[4] = new ScoreRenderer(score);
        gameRenderer = new GameRenderer(objectRenderers);

        birdHandler = new BirdHandler(bird);
        tubeHandler1 = new TubeHandler(tube1);
        tubeHandler2 = new TubeHandler(tube2);
        groundHandler = new GroundHandler(ground);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Flappy Bird by Bulcsu");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(gameRenderer);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                if(gameRenderer.isFinished()) {
                    restart();
                    return;
                }

                if (!gameRenderer.isStarted()) {
                    gameRenderer.setStarted(true);
                    timer.start();
                }

                birdHandler.handleMouseEvent(e);
            }
        });

        this.setVisible(true);
    }

    public void restart() {
        bird.setX(100);
        bird.setY(200);
        bird.setAlive(true);

        tube1.setX(WIDTH);
        tube1.setY(150);

        tube2.setX(WIDTH + 175);
        tube2.setY(100);

        score.setScore(0);

        timer.stop();

        gameRenderer.setStarted(false);
        gameRenderer.setFinished(false);
        gameRenderer.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(bird.isAlive()) {
            birdHandler.tick();
            tubeHandler1.tick(birdHandler, score);
            tubeHandler2.tick(birdHandler, score);
            groundHandler.tick(birdHandler);
            gameRenderer.repaint();
        }
        else {
            gameRenderer.setFinished(true);
            gameRenderer.repaint();
        }
    }

    public static void main(String[] args) {
        new Game(1200, 200);
    }
}