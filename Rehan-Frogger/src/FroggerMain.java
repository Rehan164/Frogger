import javax.swing.*;

import sprites.Car;
import sprites.Frog;
import sprites.Resources;
import sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FroggerMain extends JPanel {

    private Timer timer;

    private Frog frog;

    private ArrayList<Car> cars1, cars2, cars3, cars4, cars5;

    public FroggerMain(int w, int h){
        setSize(w, h);

        frog = new Frog(Resources.normFrog1, new Point(208, 448));

        cars1 = new ArrayList<>();
        cars2 = new ArrayList<>();
        cars3 = new ArrayList<>();
        cars4 = new ArrayList<>();
        cars5 = new ArrayList<>();

        cars1.add(new Car(Resources.car1, new Point(448, 416), 1));
        cars1.add(new Car(Resources.car1, new Point(610, 416), 1));
        cars1.add(new Car(Resources.car1, new Point(772, 416), 1));

        cars2.add(new Car(Resources.car2, new Point(-128, 384), 2));
        cars2.add(new Car(Resources.car2, new Point(-350, 384), 2));

        cars3.add(new Car(Resources.car3, new Point(450, 352), 3));
        cars3.add(new Car(Resources.car3, new Point(600, 352), 3));
        cars3.add(new Car(Resources.car3, new Point(750, 352), 3));

        cars4.add(new Car(Resources.car4, new Point(-32, 320), 4));

        cars5.add(new Car(Resources.truck, new Point(448, 288), 5));
        cars5.add(new Car(Resources.truck, new Point(722, 288), 5));

        timer = new Timer(1000/60, e->update());
        timer.start();
        setupKeyListener();
    }

    // called every frame (60 times per second by default) by the timer
    public void update(){

        for (Car car : cars1) {
            car.move(1);
            if(frog.intersects(car)) {
                frog.setDied(true, false);  
            }
        }
        for (Car car : cars2) {
            car.move(1);
            if(frog.intersects(car)) {
                frog.setDied(true, false);  
            }
        }
        for (Car car : cars3) {
            car.move(2);
            if(frog.intersects(car)) {
                frog.setDied(true, false);   
            }
        }
        for (Car car : cars4) {
            car.move(3);
            if(frog.intersects(car)) {
                frog.setDied(true, false);  
            }
        }
        for (Car car : cars5) {
            car.move(3);
            if(frog.intersects(car)) {
                frog.setDied(true, false);  
            }
        }

        if(frog.getY() < 244 && frog.getY() > 96) {
            frog.setDied(true, true);
        }


        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(Resources.background, 0, 48, null);
        g2.setColor(new Color(0, 0, 71, 225));
        g2.fillRect(0, 0, 448, 48);
        // all drawing happens here.
        // Best practice is to NOT change the state of any instance fields
        // so the graphics can update at any time
        setBackground(Color.BLACK);

        for (Car car : cars1) {
            car.draw(g2);

            if(car.getX() < 0 - car.getWidth()) {
                car.setLocation(new Point(448, 416));
            }
        }
        for (Car car : cars2) {
            car.draw(g2);

            if(car.getX() > 488) {
                car.setLocation(new Point(-32, 384));
            }
        }

        for (Car car : cars3) {
            car.draw(g2);

            if(car.getX() < 0 - car.getWidth()) {
                car.setLocation(new Point(448, 352));
            }
        }

        for (Car car : cars4) {
            car.draw(g2);

            if(car.getX() > 488) {
                car.setLocation(new Point(-32, 320));
            }
        }

        for (Car car : cars5) {
            car.draw(g2);

            if(car.getX() < 0 - car.getWidth()) {
                car.setLocation(new Point(448, 288));
            }
        }

        frog.draw(g2);

    }

    public void setupKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if(e.getKeyChar() == 'w' && frog.getY() > 64 && !frog.getDied()) {
                    frog.moveUp();
                }
                if(e.getKeyChar() == 's' && frog.getY() < 448 && !frog.getDied()) {
                    frog.moveDown();
                }
                if(e.getKeyChar() == 'a' && frog.getX() > 0 && !frog.getDied()) {
                    frog.moveLeft();
                }
                if(e.getKeyChar() == 'd' && frog.getX() < getWidth() - frog.getWidth() && !frog.getDied()) {
                    frog.moveRight();
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
        window.setBounds(0, 0, 448, 540 + 22); //(x, y, w, h) 22 due to title bar.

        FroggerMain panel = new FroggerMain(448, 512);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
