package sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Lilypad extends Sprite{

    private int animatorCounter;

    public Lilypad(BufferedImage image, Point location) {
        super(image, location);
    }

    public void move(int speed) {
        super.move(-speed, 0);
    }

    public void draw(Graphics2D g2){
        animatorCounter +=2;

        if(animatorCounter == 20) {
            setImage(Resources.lilypad1);
            animatorCounter = 0;

        }
        else if(animatorCounter == 12) {
            setImage(Resources.lilypad3);
        }
        else if(animatorCounter == 4) {
            setImage(Resources.lilypad2);
        }

        super.draw(g2);
    }
}
