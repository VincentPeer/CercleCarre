package world.Shapes;
import utils.Renderer;
import world.WorldView;
import world.animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Square extends MovingShape {

    public Square(double posX, double posY, double size, Motion motion, Color color, Renderer renderer, Container graph) {
        super(posX, posY, size, motion, color, renderer, graph);
    }
    Shape makeShape(double posX, double posY, double size) {
        return new Rectangle2D.Double(posX, posY, size, size);
    }

}
