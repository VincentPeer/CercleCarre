package utils;

import bouncers.Shapes.Bounceable;
import bouncers.Shapes.Circle;

import java.awt.*;

public class OutlineRenderer implements Renderer {

    /**
     * Colors the outline of a  given shape / Bounceable
     * @param g the graphics to draw on
     * @param b the shape / Bounceable to draw
     */
    @Override
    public void display(Graphics2D g, Bounceable b) {
        if (g != null) {
            g.setColor(b.getColor());
            g.draw(b.getShape());
        }
    }
}
