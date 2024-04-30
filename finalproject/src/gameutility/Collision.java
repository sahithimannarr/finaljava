package gameutility;

import java.awt.Rectangle;

public class Collision {
    public static boolean checkCollision(Rectangle obj1, Rectangle obj2) {
        return obj1.intersects(obj2);
    }
}