import javax.swing.*;

import sprites.Frog;
import sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FroggerMain extends JPanel {

    private Timer timer;

    private Frog frog; // I haven't made a Frog class yet, but you should, and change this type to Frog

    public FroggerMain(int w, int h){
        setSize(w, h);

        frog = new Frog(Resources.frog_up, new Point(300, 300));



        timer = new Timer(1000/60, e->update());
        timer.start();
        setupKeyListener();
    }

    // called every frame (60 times per second by default) by the timer
    public void update(){
        // update any time-based changes here


    

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // all drawing happens here.
        // Best practice is to NOT change the state of any instance fields
        // so the graphics can update at any time
        setBackground(Color.BLACK);
        frog.draw(g2);


    }

    public void setupKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if(e.getKeyChar() == 'w' && frog.getY() > 0) {
                    frog.moveUp();
                    frog.setImage(Resources.frog_up);
                }
                if(e.getKeyChar() == 's' && frog.getY() < getHeight() - frog.getHeight()) {
                    frog.moveDown();
                    frog.setImage(Resources.frog_down);
                }
                if(e.getKeyChar() == 'a' && frog.getX() > 0) {
                    frog.moveLeft();
                    frog.setImage(Resources.frog_left);
                }
                if(e.getKeyChar() == 'd' && frog.getX() < getWidth() - frog.getWidth()) {
                    frog.moveRight();
                    frog.setImage(Resources.frog_right);
                }

            }
            @Override
            public void keyPressed(KeyEvent e) {
                // if you want to use arrows:
                // if(e.getKeyCode() == KeyEvent.VK_UP)a
                //      frog.moveUp();
            }
            @Override
            public void keyReleased(KeyEvent e) { }
        });
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Frogger");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 600, 600 + 22); //(x, y, w, h) 22 due to title bar.

        FroggerMain panel = new FroggerMain(800, 800);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
