package world.Shapes.movingShapes;
import world.animation.Motion;
import world.Shapes.Shape;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class Square extends MovingShape {

    double size;
    public Square(double posX, double posY, double size, Motion motion) {
        super(posX, posY, motion);
        this.size = size;
    }

    @Override
    public Double isColliding(List<Shape> shapes) {
        // todo just pour test
        for (Shape s : shapes) {
            if (s.isCollided(getPosX(), getPosY())) {
                return s.getAngle();
            }
        }
        return null;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(getPosX(), getPosY(), size, size);
        g2d.setColor(Color.black);
        g2d.fill(rect);
    }
}
