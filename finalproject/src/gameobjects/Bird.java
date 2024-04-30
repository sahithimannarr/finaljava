package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

public class Bird extends GameObject {
    public Bird(int x, int y, int size) {
        super(x, y, size, size);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }
}