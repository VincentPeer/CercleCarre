package bouncers.Shapes;

import bouncers.Displayer;
import utils.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends MovingShape {

    /**
     * Use of the super constructor to build a square of random size, direction, speed and start position
     * @param color color of the square
     * @param renderer renderer used to draw the square
     * @param displayer displayer on witch to draw the square on
     */
    public Square(Color color, Renderer renderer, Displayer displayer) {
        super(color, renderer, displayer);
    }


    /**
     * @return A square shaped  AWT Shape
     */
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }

}
