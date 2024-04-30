package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

public class Pipe extends GameObject {
    public Pipe(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN.darker());
        g.fillRect(x, y, width, height);
    }
}