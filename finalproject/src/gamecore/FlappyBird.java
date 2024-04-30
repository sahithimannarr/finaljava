package gamecore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import gameobjects.*;
import gameutility.*;
import gameexceptions.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PIPE_WIDTH = 60;
    private static final int PIPE_GAP = 150;
    private static final int BIRD_SIZE = 30;

    private Bird bird;
    private ArrayList<Pipe> pipes;
    private boolean gameOver;
    private int score;
    private JButton restartButton;

    public FlappyBird() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        pipes = new ArrayList<>();
        gameOver = false;
        score = 0;

        bird = new Bird(WIDTH / 2 - BIRD_SIZE / 2, HEIGHT / 2, BIRD_SIZE);

        restartButton = new JButton("Restart");
        restartButton.setBounds(WIDTH / 2 - 50, HEIGHT / 2 + 50, 100, 30);
        restartButton.addActionListener(this);
        restartButton.setVisible(false);
        add(restartButton);

        Timer timer = new Timer(20, this);
        timer.start();

        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);
    }

    public void addPipe(boolean start) {
        int pipeX = WIDTH;
        int pipeY = new Random().nextInt(HEIGHT - PIPE_GAP);

        if (start) {
            pipeX = WIDTH + WIDTH / 2 + pipes.size() * 300;
        }

        pipes.add(new Pipe(pipeX, 0, PIPE_WIDTH, pipeY));
        pipes.add(new Pipe(pipeX, pipeY + PIPE_GAP, PIPE_WIDTH, HEIGHT - pipeY - PIPE_GAP));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.GREEN);
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);

        g.setColor(Color.RED);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        bird.draw(g);

        for (Pipe pipe : pipes) {
            pipe.draw(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("Score: " + score, 20, 50);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over!", WIDTH / 2 - 100, HEIGHT / 2);
            restartButton.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            restartGame();
        } else {
            if (!gameOver) {
                for (int i = 0; i < pipes.size(); i++) {
                    Pipe pipe = pipes.get(i);
                    pipe.setX(pipe.getX() - 5);
                }

                bird.setY(bird.getY() + 1);

                try {
                    Rectangle birdRect = new Rectangle(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

                    for (Pipe pipe : pipes) {
                        Rectangle pipeRect = new Rectangle(pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight());
                        if (Collision.checkCollision(birdRect, pipeRect)) {
                            throw new CollisionException("Bird collided with a pipe!");
                        }
                    }

                    if (bird.getY() > HEIGHT - 120 || bird.getY() < 0) {
                        throw new OutOfBoundsException("Bird went out of bounds!");
                    }

                    if (pipes.get(0).getX() + PIPE_WIDTH < 0) {
                        pipes.remove(0);
                        pipes.remove(0);
                        addPipe(false);
                        score++;
                    }
                } catch (CollisionException | OutOfBoundsException ex) {
                    gameOver = true;
                    System.out.println(ex.getMessage());
                }
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.setY(bird.getY() - 50);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void restartGame() {
        pipes.clear();
        gameOver = false;
        score = 0;
        bird.setY(HEIGHT / 2);
        restartButton.setVisible(false);
        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);
        requestFocus();
    }
}