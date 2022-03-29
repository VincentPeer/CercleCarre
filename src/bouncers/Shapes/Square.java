package bouncers.Shapes;

import bouncers.Displayer;
import utils.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends MovingShape {

    public Square(Color color, Renderer renderer, Displayer world) {
        super(color, renderer, world);
    }

    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }

}
