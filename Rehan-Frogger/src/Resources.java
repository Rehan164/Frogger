import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class Resources {
    // to add an image to the environment:
    // 1. put the file into the res folder.
    // 2. Declare a variable before the static block.
    // 3. Initialize the variable by copying and pasting and modifying the
    //    ImageIO line.


    public static BufferedImage frog_up, frog_down, frog_right, frog_left;

    static{
        try{
            frog_up = ImageIO.read(new File("./res/frog_up.png"));
            frog_down = ImageIO.read(new File("./res/frog_down.png"));
            frog_right = ImageIO.read(new File("./res/frog_right.png"));
            frog_left = ImageIO.read(new File("./res/frog_left.png"));



        }catch(Exception e){e.printStackTrace();}
    }
}
