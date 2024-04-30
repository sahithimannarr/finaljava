
import javax.swing.*;
import gamecore.FlappyBird;

public class Main {
    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Flappy Bird");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            FlappyBird flappyBird = new FlappyBird();
            frame.add(flappyBird);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            flappyBird.requestFocus();
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}