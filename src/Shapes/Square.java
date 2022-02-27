package Shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class Square extends Shape{
    double size;
    public Square(double posX, double posY, double size) {
        super(posX, posY);
        this.size = size;
    }

    @Override
    public boolean isInContact() {
        return false;
    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(50, 50, 50, 50);

        g2d.setColor(Color.black);
        g2d.fill(rect);
        //g2d.drawRect((int) super.posX, (int) super.posY, (int) size, (int) size);
    }
}
