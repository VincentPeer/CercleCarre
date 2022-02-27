// importing Java AWT class
import Shapes.Shape;
import Shapes.Square;

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

        // setting the title of Frame
       //setTitle("Bouncers");

        // no layout manager
        //setLayout(null);

        // Add shape todo test
        shapes.add(new Square(50, 50, 50));
        repaint();

        // now frame will be visible, by default it is not visible
        setVisible(true);



//        this.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent e) {
//                dispose();
//            }
//        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}
