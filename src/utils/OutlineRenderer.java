package utils;

import utils.Renderer;
import world.Shapes.movingShapes.Bouceable;

import java.awt.*;

public class OutlineRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouceable b) {
        g.draw(b.getShape());
    }
}
