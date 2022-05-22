package sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Logs extends Sprite{

    private int w, h;
    private BufferedImage image;
    private int length;

    public Logs(BufferedImage image, Point location, int logLength) { // 2, 3, 4
        super(image, location);

        this.image = image;
        length = logLength;

        w = image.getWidth() * logLength;
        h = image.getHeight()* logLength;
        
    }

    public void move(int speed) {
        super.move(speed, 0);
    }
    
    @Override
    public void draw(Graphics2D g2){

        if(length == 2) {
            g2.drawImage(image, getLocation().x, getLocation().y, null);
            g2.drawImage(Resources.logRight, getLocation().x + 32, getLocation().y, null);
        }
        else if(length == 3) {
            g2.drawImage(image, getLocation().x, getLocation().y, null);
            g2.drawImage(Resources.logCenter, getLocation().x + 32, getLocation().y, null);
            g2.drawImage(Resources.logRight, getLocation().x + 64, getLocation().y, null);
        }
        else if(length == 4) {
            g2.drawImage(image, getLocation().x, getLocation().y, null);
            g2.drawImage(Resources.logCenter, getLocation().x + 32, getLocation().y, null);
            g2.drawImage(Resources.logCenter, getLocation().x + 64, getLocation().y, null);
            g2.drawImage(Resources.logRight, getLocation().x + 96, getLocation().y, null);
        }

        g2.setColor(Color.green);
        g2.drawRect(getLocation().x, getLocation().y, getWidth(), getHeight());
        g2.setColor(Color.black);

    }

    public int getWidth() {return image.getWidth() * length;}
    public int getHeight() {return image.getHeight();}

}
