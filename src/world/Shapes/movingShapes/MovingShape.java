package world.Shapes.movingShapes;

import world.Shapes.Shape;
import world.animation.Direction;
import world.animation.Motion;
import java.awt.*;
import java.util.List;

abstract public class MovingShape extends Shape {

   private Motion motion;

   public MovingShape(double posX, double posY, Motion motion) {
      super(posX, posY);
      this.motion = motion;
   }

   public void bounce(Direction wallDir) {
      double newDir = 2 * Math.PI - motion.getDir().getRad() + 2 * wallDir.getRad();
      motion.setDir(newDir);
   }

   public void move(List<Shape> shapes) {
      Double wallDirection = isColliding(shapes);
      if (wallDirection != null)
         bounce(new Direction(wallDirection));

      setPos(getPosX() + Math.cos(motion.getDir().getRad()) * motion.getSpeed(),
             getPosY() - Math.sin(motion.getDir().getRad()) * motion.getSpeed());
   }

   abstract public Double isColliding(List<Shape> shapes);

   public boolean isCollided(double posX, double posY) {
      return false;
   }

   public Double getAngle() {
      return 0.0;
   }

   abstract public void draw(Graphics g);
}
