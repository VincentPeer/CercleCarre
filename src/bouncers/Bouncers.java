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
    private final int panelWidth = 600 , panelHeight = 600;

    class Ticks implements Runnable {
        /**
         * run method of Runnable thread witch updates the position of the shapes and redraws the graphics.
         * Each loop represents one tick
         */
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
                    // Repaint main displayer and children
                    displayer.repaint();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Constructor of Bouncer the class, initialise all components, creates a Displayer and
     * ads the KeyListener to the main window.
     */
    public Bouncers() {
        // semaphore to block simultaneous access to bouncers
        sem = new Semaphore(1);
        bouncers = new LinkedList<>();
        displayer =  Display.getInstance(panelWidth, panelHeight);
        displayer.setTitle("Bouncers");
        // keyListener to add Bounceables and other
        displayer.addKeyListener(new KeyActions(this));
    }

    // Our main methode, stars a new bouncer class and runs it
    public static void main(String ... args) {
        new Bouncers().run();
    }

    /**
     * Starts a Runnable thread representing ticks
     */
    public void run () {
        run = true;
        thread = new Thread(new Ticks());
        thread.start();
    }

    /**
     * Stops the thread and closes the application
     */
    public void quit() {
        // Stopping the thread's loop
        run = false;
        try {
            // Waiting for the thread to finish
            thread.join();
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds shapes to be drawn
     * @param nbShapes number of square and circles to be drawn
     * @param cColor circle color
     * @param sColor square color
     * @param renderer renderer to be used to draw the shapes
     */
    public void addShapes (int nbShapes, Color cColor, Color sColor, Renderer renderer) {
        try {
            // For thread safe access to bouncers
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

    /**
     * Removes all the shapes in our list.
     */
    public void clearShapes() {
        bouncers.clear();
    }
}
