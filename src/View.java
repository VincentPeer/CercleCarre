// importing Java AWT class
import world.Shapes.Shape;
import world.Shapes.Wall;
import world.Shapes.movingShapes.MovingShape;
import world.Shapes.movingShapes.Square;
import world.animation.Direction;
import world.animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JPanel {
    private List<MovingShape> movingShapes = new ArrayList<>();
    private List<Shape> staticShapes = new ArrayList<>();

    View() {
        // frame size 300 width and 300 height
        int frameWidth = 400;
        int frameHeight = 400;
        setPreferredSize(new Dimension(400, 400));

        // Add shape todo test
        movingShapes.add(new Square(50, 200, 50, new Motion(new Direction(Math.PI / 4), 2)));

        // Adding walls
        staticShapes.add(new Wall(0, 0, frameWidth, new Direction(0)));
        staticShapes.add(new Wall(0, frameHeight, frameWidth, new Direction(0)));
        staticShapes.add(new Wall(0, 0, frameHeight, new Direction(Math.PI / 2)));
        staticShapes.add(new Wall(frameWidth, 0, frameHeight, new Direction(Math.PI / 2)));

        repaint();

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }

    public void move() {
        while (true) {
            for (MovingShape s : movingShapes)
                s.move(staticShapes);
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MovingShape s : movingShapes) {
            s.draw(g);
        }
    }
}
