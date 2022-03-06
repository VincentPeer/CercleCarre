package world.Shapes.movingShapes;

import world.animation.Motion;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Circle extends MovingShape{
    double radius;
    public Circle(double posX, double posY, int radius, Motion motion) {
        super(posX, posY, motion);
        this.radius = radius;
    }

    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D circle = new RoundRectangle2D.Double(getPosX(), getPosY(), radius, radius, radius, radius);
        g2d.setColor(Color.black);
        g2d.fill(circle);
    }

    @Override
    public Double getMostRight() {
        return getPosX() + radius;
    }

    @Override
    public Double getMostLeft() {
        return getPosX();
    }

    @Override
    public Double getMostUp() {
        return getPosY();
    }

    @Override
    public Double getMostDown() {
        return getPosY() + radius;
    }
}
