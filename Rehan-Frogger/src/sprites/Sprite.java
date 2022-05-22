package sprites;
import java.awt.*;
import java.awt.image.BufferedImage;

/* This class represents a Sprite in a game.
   Sprites have an image and location, and can
   detect collision/intersection with another Sprite.
   This class is set up to have rectangular collision
   detection - rectangles intersecting rectangles.
 */

public class Sprite {

    private BufferedImage image;
    private Point location;

    public Sprite(BufferedImage image, Point location) {
        this.image = image;
        this.location = location;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, location.x, location.y, null);
    }

    public boolean intersects(Sprite other){
        Rectangle hitBox = new Rectangle(location.x, location.y, image.getWidth(), image.getHeight());
        Rectangle otherHitBox = new Rectangle(other.location.x, other.location.y, other.getWidth(), other.getHeight());
        return hitBox.intersects(otherHitBox);
    }

    public void move(int dx, int dy){
        location.translate(dx, dy);
    }

    public int getX() {return location.x;}
    public int getY() {return location.y;}
    public int getWidth() {return image.getWidth();}
    public int getHeight() {return image.getHeight();}

    public void setImage(BufferedImage image) { this.image = image; }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}









//Rubric: NOT AT ALL DONE
//    30 points available
//
//    points:
//    Frog moves around, Cars move in both directions with multiple images in multiple rows.
//    Cars cause Frog to die, lives + game over
//
//    25 points:
//    Water
