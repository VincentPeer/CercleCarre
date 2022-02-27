// importing Java AWT class
import Shapes.Shape;
import Shapes.Square;
import animation.Direction;
import animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class View extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    // initializing using constructor
    View() {

        // frame size 300 width and 300 height
        setPreferredSize(new Dimension(400, 400));

        // Add shape todo test
        shapes.add(new Square(50, 200, 50, new Motion(new Direction(Math.PI / 4), 2)));
        repaint();

        // now frame will be visible, by default it is not visible
        setVisible(true);

    }

    public void move() {
        while (true) {
            for (Shape s : shapes) {
                s.move();
            }
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
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}
