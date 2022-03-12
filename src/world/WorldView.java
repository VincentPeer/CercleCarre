package world;
import world.Shapes.movingShapes.MovingShape;

import javax.swing.*;
import java.awt.*;

public class WorldView extends JPanel {

    private final Content content;

    class Time implements Runnable {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public WorldView(int width, int height, int nbObjects) {
        content = new Content(width, height, nbObjects);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        new Thread(new Time()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MovingShape s : content.getContent())
            s.draw(g);
    }
}
