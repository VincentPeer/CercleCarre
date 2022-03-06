package world.Shapes.movingShapes;

import world.animation.Motion;

import javax.swing.*;
import java.awt.*;

abstract public class MovingShape extends JComponent {
   private double posX, posY;
   private final Motion motion;

   public MovingShape(double posX, double posY, Motion motion) {
      this.posX = posX;
      this.posY = posY;
      this.motion = motion;
   }

   public void bounce(Double wallAngle) {
      double newDir = 2 * Math.PI - motion.getDir() + 2 * wallAngle;
      motion.setDir(newDir);
   }

   public void move(Graphics g) {
      if (g != null) {
         if (getMostLeft() <= 0 || getMostRight() >= g.getClipBounds().getWidth())
            bounce(Math.PI / 2);
         else if (getMostUp() <= 0 || getMostDown() >= g.getClipBounds().getHeight())
            bounce(0.);

         posX += Math.cos(motion.getDir()) * motion.getSpeed();
         posY -= Math.sin(motion.getDir()) * motion.getSpeed();
      }else
         System.out.println("null");
   }

   public double getPosX() {
      return posX;
   }
   public double getPosY() {
      return posY;
   }

   public void draw(Graphics g) {
      move(g);
   }

   abstract public Double getMostLeft();
   abstract public Double getMostRight();
   abstract public Double getMostUp();
   abstract public Double getMostDown();




}
