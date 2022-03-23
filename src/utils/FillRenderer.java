package utils;

import world.Shapes.Bounceable;
import world.Shapes.Circle;

import java.awt.*;

public class FillRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bounceable b) {
        if (g != null) {
            Color color;
            if (b instanceof Circle)
                color = Color.BLUE;
            else
                color = Color.ORANGE;
            g.setColor(color);
            g.fill(b.getShape());
        }
    }
}
