package world.Shapes.movingShapes;
import world.WorldView;
import world.animation.Motion;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends MovingShape {

    public Square(double posX, double posY, double size, Motion motion, Color color, utils.Renderer renderer, WorldView graph) {
        super(posX, posY, size, motion, color, renderer, graph);
    }
    Shape makeShape(double posX, double posY, double size) {
        return new Rectangle2D.Double(posX, posY, size, size);
    }
}
