package world;

import utils.FillRenderer;
import world.Shapes.movingShapes.Bouceable;
import world.Shapes.movingShapes.Circle;
import world.Shapes.movingShapes.Square;
import world.animation.Motion;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.awt.*;

public class Content {
    private LinkedList<Bouceable> bouncers;

    public Content(int width, int height, int nbObjects, WorldView graph) {
        bouncers = new LinkedList<>();

        // Add shapes
        Random rand = new Random();
        for (int i = 0; i < nbObjects; ++i) {
            int size = rand.nextInt(Math.min(width,height) / 15) + 4;
            double posX = rand.nextInt(width - size);
            double posY = rand.nextInt(height - size);
            Motion motion = new Motion(rand.nextDouble() * 2 * Math.PI, rand.nextFloat());

            if (rand.nextBoolean())
                bouncers.add(new Square(posX, posY , size, motion, Color.BLUE, new FillRenderer(), graph));
            else
                bouncers.add(new Circle(posX, posY, size, motion, Color.BLUE, new FillRenderer(), graph));
        }
    }


    public List<Bouceable> getContent() {
        return bouncers;
    }


}
