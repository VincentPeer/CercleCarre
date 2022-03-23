package world.Shapes;

import world.animation.Motion;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

abstract public class MovingShape implements Bounceable {
   private final Motion motion;
   private final double size;
   private final Color color;
   private final utils.Renderer renderer;
   private Shape shape;
   private Container graph;

   public MovingShape(double posX, double posY, double size, Motion motion, Color color,  utils.Renderer renderer, Container graph) {
      this.size = size;
      this.motion = motion;
      this.color = color;
      this.renderer = renderer;
      shape = makeShape(posX, posY, size);
      this.graph = graph;
   }

   public void bounce(Double wallAngle) {
      double newDir = 2 * Math.PI - motion.getDir() + 2 * wallAngle;
      motion.setDir(newDir);
   }

   public void move() {
      Graphics2D g =(Graphics2D) graph.getGraphics();

      if (g != null) {
         if (shape.getBounds().getMinX() <= 0 || shape.getBounds().getMaxX() >= graph.getWidth())
            bounce(Math.PI / 2);
         else if (shape.getBounds().getMinY() <= 0 || shape.getBounds().getMaxY() >= graph.getHeight())
            bounce(0.);

         double posX = shape.getBounds2D().getX() + Math.cos(motion.getDir()) * motion.getSpeed();
         double posY = shape.getBounds2D().getY() - Math.sin(motion.getDir()) * motion.getSpeed();
         shape = makeShape(posX, posY, size);
      }
   }

   public void draw() {
      renderer.display((Graphics2D) graph.getGraphics(), this);
   }

   public Color getColor() {
      return color;
   }
   public Shape getShape (){
      return shape;
   }

   abstract Shape makeShape(double posX, double posY, double size);

}
