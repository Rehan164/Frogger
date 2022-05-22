package sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Car extends Sprite{

    private int direction;

    private int w, h;
    private BufferedImage image;

    public Car(BufferedImage image, Point location, int row) {
        super(image, location);

        this.image = image;

        w = image.getWidth();
        h = image.getHeight();

        if(row % 2 == 0) {
            direction = 1; // to the right
        }
        else {
            direction = -1;
        }
    }
    
    public void move(int speed) {
        if(direction == -1) {
            super.move(-speed, 0);
        }
        else {
            super.move(speed, 0);
        }
    }


    public void flipDraw(Graphics2D g2) {
        g2.translate(getX()+w/2, getY()+h/2); //shift the origin to the center of our rect
        g2.rotate(Math.toRadians(180));   //rotate the entire panel.

        g2.drawImage(image, -w/2, -h/2, null);

        g2.rotate(-Math.toRadians(180));  //put the panel back
        g2.translate(-(getX()+w/2), -(getY()+h/2));   //put the origin back
    }

    
}
