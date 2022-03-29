package bouncers.Shapes;


import bouncers.Displayer;
import utils.Renderer;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Circle extends MovingShape{

    /**
     * Use of the super constructor to build a circle of random size, direction, speed and start position
     * @param color color of the circle
     * @param renderer renderer used to draw the circle
     * @param displayer displayer on witch to draw the circle on
     */
    public Circle(Color color, Renderer renderer, Displayer displayer) {
        super(color, renderer, displayer);
    }

    /**
     * @return A Circle shaped  AWT Shape
     */
    public Shape getShape() {
        return new RoundRectangle2D.Double(getX(), getY(), getSize(), getSize(), getSize(), getSize());
    }
}
