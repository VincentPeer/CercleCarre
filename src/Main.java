import Shapes.Square;

import javax.swing.*;

public class Main {

    public static void main(String ... args) {
        JFrame frame = new JFrame();
        View view = new View();
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        view.move();


//        //1. Create the frame.
//        View view = new View();
    }
}
