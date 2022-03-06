package world;

import world.Shapes.movingShapes.MovingShape;

import java.util.LinkedList;
import java.util.List;

public class Content {
    List<MovingShape> shapes;

    public Content() {
        shapes = new LinkedList<>();
        // Add shape todo test
        //shapes.add(new Square(50, 200, 50, new Motion(new Direction(Math.PI / 4), 2)));
        //shapes.add(new Circle(200, 200, 50, new Motion(new Direction(Math.PI / 3), 2)));
    }

    public void move(View view) {
        while (true) {
            view.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
