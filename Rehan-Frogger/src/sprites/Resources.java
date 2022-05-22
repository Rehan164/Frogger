package sprites;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
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
    public static BufferedImage logLeft, logRight, logCenter;
    public static BufferedImage squish1, squish2, squish3, death, drown1, drown2, drown3;

    public static BufferedImage frogger1;

    public static BufferedImage background;

    public static BufferedImage empty, finisher;

    public static BufferedImage lives;

    public static BufferedImage normFrog1, normFrog2, normFrog3;
    public static BufferedImage lilypad1, lilypad2, lilypad3;

    public static Clip jump, squash, plunk;

    static{
        try{
            frogger1 = ImageIO.read(new File("./res/froggerNew.png"));
            background = ImageIO.read(new File("./res/mapFroggerNew.png"));

            normFrog1 = frogger1.getSubimage(0, 0, 32, 32);   
            normFrog2 = frogger1.getSubimage(32, 0, 32, 32);
            normFrog3 = frogger1.getSubimage(64, 0, 32, 32);

            lives = background.getSubimage(2, 482, 14, 14);

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

            logLeft = frogger1.getSubimage(192, 256, 32, 32);
            logCenter = frogger1.getSubimage(224, 256, 32, 32);
            logRight = frogger1.getSubimage(256, 256, 32, 32);

            lilypad1 = frogger1.getSubimage(0, 160, 32, 32);
            lilypad2 = frogger1.getSubimage(32, 160, 32, 32);
            lilypad3 = frogger1.getSubimage(64, 160, 32, 32);

            empty = frogger1.getSubimage(192, 224, 32, 32);
            finisher = frogger1.getSubimage(96, 192, 32, 32);

            File j = new File("./res/hop.wav");
            AudioInputStream audioStreamj = AudioSystem.getAudioInputStream(j);
            jump = AudioSystem.getClip();
            jump.open(audioStreamj);

            File p = new File("./res/plunk.wav");
            AudioInputStream audioStreamp = AudioSystem.getAudioInputStream(p);
            plunk = AudioSystem.getClip();
            plunk.open(audioStreamp);

            File s = new File("./res/squash.wav");
            AudioInputStream audioStreams = AudioSystem.getAudioInputStream(s);
            squash = AudioSystem.getClip();
            squash.open(audioStreams);
            

        }catch(Exception e){e.printStackTrace();}
    }
}
