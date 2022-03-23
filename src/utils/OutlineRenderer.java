package utils;

import world.Shapes.Bounceable;
import world.Shapes.Circle;

import java.awt.*;

public class OutlineRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bounceable b) {
        if (g != null) {
            Color color;
            if (b instanceof Circle)
                color = Color.green;
            else
                color = Color.RED;
            g.setColor(color);
            g.draw(b.getShape());
        }
    }
}
