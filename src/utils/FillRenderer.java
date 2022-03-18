package utils;

import world.Shapes.movingShapes.Bouceable;
import java.awt.*;

public class FillRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouceable b) {
        g.fill(b.getShape());
    }
}
