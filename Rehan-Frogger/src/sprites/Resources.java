package sprites;

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


    public static BufferedImage car1, car2, car3, car4, truck;
    public static BufferedImage squish1, squish2, squish3, death, drown1, drown2, drown3;

    public static BufferedImage frogger1;

    public static BufferedImage background;

    public static BufferedImage normFrog1, normFrog2, normFrog3;

    static{
        try{
            frogger1 = ImageIO.read(new File("./res/froggerNew.png"));
            background = ImageIO.read(new File("./res/mapFroggerNew.png"));

            normFrog1 = frogger1.getSubimage(0, 0, 32, 32);   
            normFrog2 = frogger1.getSubimage(32, 0, 32, 32);
            normFrog3 = frogger1.getSubimage(64, 0, 32, 32);

            background = background.getSubimage(0, 48, 448, 432);

            car1 = frogger1.getSubimage(96, 0, 32, 32);
            car2 = frogger1.getSubimage(128, 0, 32, 32);
            car3 = frogger1.getSubimage(224, 0, 32, 32);
            car4 = frogger1.getSubimage(256, 0, 32, 32);
            truck = frogger1.getSubimage(160, 0, 64, 32);

            squish1 = frogger1.getSubimage(0, 128, 32, 32);
            squish2 = frogger1.getSubimage(32, 128, 32, 32);
            squish3 = frogger1.getSubimage(64, 128, 32, 32);
            death = frogger1.getSubimage(0, 96, 32, 32);

            drown1 = frogger1.getSubimage(32, 96, 32, 32);
            drown2 = frogger1.getSubimage(64, 96, 32, 32);
            drown3 = frogger1.getSubimage(96, 96, 32, 32);



        }catch(Exception e){e.printStackTrace();}
    }
}
