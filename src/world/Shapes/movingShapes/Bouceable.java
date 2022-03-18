package world.Shapes.movingShapes;

import java.awt.*;

public interface Bouceable {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
