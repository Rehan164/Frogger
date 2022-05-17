package sprites;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Frog extends Sprite {

    public Frog(BufferedImage image, Point location) {
        super(image, location);
    }

    public void moveLeft() {
        super.move(-getWidth(), 0);
    }

    public void moveRight() {
        super.move(getWidth(), 0);
    }

    public void moveUp() {
        super.move(0, -getHeight());
    }

    public void moveDown() {
        super.move(0, getHeight());
    }
    
}
