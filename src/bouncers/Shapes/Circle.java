package bouncers.Shapes;


import bouncers.Displayer;
import utils.Renderer;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Circle extends MovingShape{

    public Circle(Color color, Renderer renderer, Displayer world) {
        super(color, renderer, world);
    }

    public Shape getShape() {
        return new RoundRectangle2D.Double(x, y, size, size, size, size);
    }
}
