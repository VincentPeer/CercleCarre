package utils;

import world.Shapes.Bounceable;

import java.awt.*;

public class OutlineRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bounceable b) {

        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
