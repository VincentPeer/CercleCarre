package utils;

import bouncers.Shapes.Bounceable;
import bouncers.Shapes.Circle;

import java.awt.*;

public class FillRenderer implements Renderer {

    /**
     * Colors an area surrounded by a given shape / Bounceable
     * @param g the graphics to draw on
     * @param b the shape / Bounceable to draw
     */
    @Override
    public void display(Graphics2D g, Bounceable b) {
        if (g != null) {
            g.setColor(b.getColor());
            g.fill(b.getShape());
        }
    }
}
