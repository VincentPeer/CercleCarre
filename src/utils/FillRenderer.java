package utils;

import world.Shapes.Bounceable;
import java.awt.*;

public class FillRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bounceable b) {
        if (g != null)
            g.fill(b.getShape());
    }
}
