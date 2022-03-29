package utils;

import bouncers.Shapes.Bounceable;

import java.awt.*;

public interface Renderer {
    void display(Graphics2D g, Bounceable b);
}
