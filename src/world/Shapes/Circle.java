package world.Shapes;

import world.WorldView;
import world.animation.Motion;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Circle extends MovingShape{

    public Circle(double posX, double posY, double radius, Motion motion, Color color, utils.Renderer renderer, Container graph) {
        super(posX, posY, radius, motion, color, renderer, graph);
    }

    Shape makeShape(double posX, double posY, double size) {
        return new RoundRectangle2D.Double(posX, posY, size, size, size, size);
    }
}
