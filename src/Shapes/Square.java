package Shapes;

import animation.Motion;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape{
    double size;
    public Square(double posX, double posY, double size, Motion motion) {
        super(posX, posY, motion);
        this.size = size;
    }

    @Override
    public Double isInContact() {
        if (posY <= 0) {
            return 0.0;
        } else if (posX <= 0) {
            return Math.PI / 2;
        }

        return null;
    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(super.posX, super.posY, size, size);
        g2d.setColor(Color.black);
        g2d.fill(rect);
    }
}
