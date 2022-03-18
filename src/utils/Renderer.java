package utils;

import world.Shapes.movingShapes.Bouceable;

import java.awt.*;

public interface Renderer {
    void display(Graphics2D g, Bouceable b);
}
