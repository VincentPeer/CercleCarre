package world;
import world.Shapes.movingShapes.Bouceable;

import javax.swing.*;
import java.awt.*;

public class WorldView extends JPanel {

    private final Content content;

    class Time implements Runnable {
        @Override
        public void run() {
            while (true) {
               for (Bouceable b : content.getContent()) {
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

    public WorldView(int width, int height, int nbObjects) {
        setVisible(true);
        content = new Content(width, height, nbObjects, this);
        setPreferredSize(new Dimension(width, height));
        new Thread(new Time()).start();
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Bouceable s : content.getContent())
//            s.draw(); // todo plus de graphics 2d?
//    }

}
