package world;
import utils.FillRenderer;
import utils.Renderer;
import world.Shapes.Bounceable;
import world.Shapes.Circle;
import world.Shapes.Square;
import world.animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class WorldView extends JPanel {

    private LinkedList<Bounceable> bouncers;

    class Time implements Runnable {
        @Override
        public void run() {
            while (true) {
               for (Bounceable b : bouncers) {
                   b.move();
                   b.draw();
               }
//               repaint();// todo check if need
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public WorldView(int width, int height) {
        bouncers = new LinkedList<>();

        System.out.println("Parent : " + getParent()); //todo testing
        setPreferredSize(new Dimension(width, height));
//        setBackground(Color.BLUE);
        new Thread(new Time()).start();
        setVisible(true);
    }

    public void addShapes (int nbCercles, int nbSquares, Renderer renderer) {
        for (int i = 0; i < nbCercles; ++i)
            bouncers.add(randShape('c', renderer));

        for (int i = 0; i < nbSquares; ++i)
            bouncers.add(randShape('s', renderer));
    }

    private Bounceable randShape(char shape, Renderer renderer) {
        Random rand = new Random(); // todo initialiser qu une fois

        int size = rand.nextInt(Math.min(getWidth(),getHeight()) / 15) + 4;
        double posX = (double) getWidth() / 2;
        double posY = (double) getHeight() / 2;
        Motion motion = new Motion(rand.nextDouble() * 2 * Math.PI, rand.nextFloat());

        if (shape == 'c')
            return new Square(posX, posY , size, motion, Color.BLUE, renderer, this);
        else
            return new Circle(posX, posY, size, motion, Color.BLUE, renderer, this);

    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Bouceable s : content.getContent())
//            s.draw(); // todo plus de graphics 2d?
//    }

}
