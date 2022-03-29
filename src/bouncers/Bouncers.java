package bouncers;

import bouncers.Shapes.Circle;
import bouncers.Shapes.Square;
import utils.KeyActions;
import bouncers.Shapes.Bounceable;
import utils.Renderer;
import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Bouncers {

    private Semaphore sem;
    private final Display displayer;
    private final LinkedList<Bounceable> bouncers;
    private Thread thread;
    private boolean run;
    int panelWidth = 600 , panelHeight = 600;

    class Ticks implements Runnable {
        @Override
        public void run() {
            while (run) {
                try {
                    // Thread safe access to bouncers
                    sem.acquire();
                    for (Bounceable b : bouncers) {
                        b.move();
                        b.draw();
                    }
                    sem.release();
                    displayer.repaint();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public Bouncers() {
        // semaphore to block simultaneous access to bouncers
        sem = new Semaphore(1);
        bouncers = new LinkedList<>();
        displayer =  Display.getInstance(panelWidth, panelHeight);
        displayer.setTitle("Bouncers");
        // keyListener to add Bounceables and other
        displayer.addKeyListener(new KeyActions(this));
    }

    public static void main(String ... args) {
        new Bouncers().run();
    }

    public void run () {
        run = true;
        thread = new Thread(new Ticks());
        thread.start();
    }

    public void quit() {
        run = false;
        try {
            thread.join();
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addShapes (int nbShapes, Color cColor, Color sColor, Renderer renderer) {
        try {
            // Thread safe access to bouncers
            sem.acquire();
            for (int i = 0; i < nbShapes; ++i) {
                bouncers.add(new Circle(cColor, renderer, displayer));
                bouncers.add(new Square(sColor, renderer, displayer));
            }
            sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeShapes() {
        bouncers.clear();
    }
}
