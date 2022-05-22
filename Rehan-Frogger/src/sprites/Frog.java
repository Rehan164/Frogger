package sprites;

import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frog extends Sprite {

    private int w, h;
    private BufferedImage image;

    private int angle;
    private int animatorCounter;
    private int deathCounter;

    private boolean isJumping;

    private boolean died, inWater;

    private int lives;

    public Frog(BufferedImage image, Point location) {
        super(image, location);
        this.image = image;

        w = image.getWidth();
        h = image.getHeight();

        died = false;

        lives = 3;
    }

    public void moveLeft() {
        isJumping = true;
        super.move(-getWidth(), 0);
        angle = 270;
    }
  
    public void moveRight() {
        isJumping = true;
        super.move(getWidth(), 0);
        angle = 90;
    }

    public void moveUp() {
        isJumping = true;
        super.move(0, -getHeight());
        angle = 0;
    }

    public void moveDown() {
        isJumping = true;
        super.move(0, getHeight());
        angle = 180;
    }
    
    @Override
    public void draw(Graphics2D g2) {
        if(isJumping) {
            animatorCounter += 4;
            if(animatorCounter >= 20) {
                setImage(Resources.normFrog1);
                isJumping = false;
                animatorCounter = 0;
            }
            if(animatorCounter == 12) {
                setImage(Resources.normFrog3);
            }
            if(animatorCounter == 4) {
                setImage(Resources.normFrog2);
            }
        }

        if(died) {
            angle = 0;
            deathCounter += 4;
            if(deathCounter == 100) {
                lives --;
                died = false;
                inWater = false;
                setLocation(new Point(208, 448));
                deathCounter = 0;
                setImage(Resources.normFrog1);
            }
            if(deathCounter == 80) {
                setImage(Resources.death);
            }
            if(deathCounter == 60) {
                if(inWater) {
                    setImage(Resources.drown3);
                }
                else {
                    setImage(Resources.squish3);
                }
            }
            if(deathCounter == 40) {
                if(inWater) {
                    setImage(Resources.drown2);
                }
                else {
                    setImage(Resources.squish2);
                }
            }
            if(deathCounter == 20) {
                if(inWater) {
                    setImage(Resources.drown1);
                }
                else {
                    setImage(Resources.squish1);
                }
            }
        }

        g2.translate(getX()+w/2, getY()+h/2); //shift the origin to the center of our rect
        g2.rotate(Math.toRadians(angle));   //rotate the entire panel.
    

        g2.drawImage(image, -w/2, -h/2, null);

        g2.rotate(-Math.toRadians(angle));  //put the panel back
        g2.translate(-(getX()+w/2), -(getY()+h/2));   //put the origin back
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean getDied() {
        return died;
    }

    public void setDied(boolean died, boolean inWater) {
        this.died = died;
        this.inWater = inWater;
    }

    public void reset() {
        setLocation(new Point(208, 448));
    }

    public int getLives() {
        return lives;
    }

}
