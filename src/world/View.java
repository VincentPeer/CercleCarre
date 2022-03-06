package world;// importing Java AWT class
import world.Shapes.movingShapes.Circle;
import world.Shapes.movingShapes.MovingShape;
import world.Shapes.movingShapes.Square;
import world.animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View extends JPanel {
    private final List<MovingShape> movingShapes = new ArrayList<>();

    public View() {
        int width = 600, height = 500, objectCnt = 500;
        setPreferredSize(new Dimension(width, height));

        Random rand = new Random();
        // Add shape todo test
        for (int i = 0; i < objectCnt; ++i) {
            movingShapes.add(new Square(rand.nextInt() % width - 30, rand.nextInt() % height - 30 , rand.nextInt() % 30, new Motion(rand.nextDouble() % 2 * Math.PI, rand.nextFloat())));
            movingShapes.add(new Circle(rand.nextInt() % width - 30, rand.nextInt() % height - 30, rand.nextInt() % 30, new Motion(rand.nextDouble() % 2 * Math.PI, rand.nextFloat())));
        }
        repaint();

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MovingShape s : movingShapes)
            s.draw(g);
    }
}
