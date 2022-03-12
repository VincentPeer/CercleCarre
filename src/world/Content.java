package world;

import world.Shapes.movingShapes.Circle;
import world.Shapes.movingShapes.MovingShape;
import world.Shapes.movingShapes.Square;
import world.animation.Motion;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Content {
    List<MovingShape> shapes;

    public Content(int width, int height, int nbObjects) {
        shapes = new LinkedList<>();

        // Add shapes
        Random rand = new Random();
        for (int i = 0; i < nbObjects; ++i) {
            int size = rand.nextInt(Math.min(width,height) / 15) + 4;
            double posX = rand.nextInt(width - size);
            double posY = rand.nextInt(height - size);
            Motion motion = new Motion(rand.nextDouble() * 2 * Math.PI, rand.nextFloat());

            if (rand.nextBoolean())
                shapes.add(new Square(posX, posY , size, motion));
            else
                shapes.add(new Circle(posX, posY, size, motion));
        }
    }


    public List<MovingShape> getContent() {
        return shapes;
    }


}
