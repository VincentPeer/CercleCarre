package world.Shapes.movingShapes;

import world.WorldView;
import world.animation.Motion;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

abstract public class MovingShape implements Bouceable{
   private double posX, posY;
   private final double size;
   private final Motion motion;
   private final Color color;
   private final utils.Renderer renderer;
   private Shape shape;
   private WorldView graph;

   public MovingShape(double posX, double posY, double size, Motion motion, Color color,  utils.Renderer renderer, WorldView graph) {
      this.posX = posX;
      this.posY = posY;
//      setLocation((int) posX, (int) posY);
      this.motion = motion;
      this.color = color;
      this.size = size;
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
         if (getMostLeft() <= 0 || getMostRight() >= graph.getWidth())
            bounce(Math.PI / 2);
         else if (getMostUp() <= 0 || getMostDown() >= graph.getHeight())
            bounce(0.);

         // todo pas test vois s que ca fait
         //((Graphics2D) shape).translate( Math.cos(motion.getDir()) * motion.getSpeed(), - Math.sin(motion.getDir()) * motion.getSpeed());

         posX += Math.cos(motion.getDir()) * motion.getSpeed();
         posY -= Math.sin(motion.getDir()) * motion.getSpeed();
         shape = makeShape(posX, posY, size);
//         shape.getBounds().setLocation((int) posX, (int) posY);
//         setLocation((int) posX, (int) posY);
      }
   }

   public void draw() {
      renderer.display((Graphics2D) graph.getGraphics(), this);
   }

//   public double getPosX() {
//      return posX;
//   }
//   public double getPosY() {
//      return posY;
//   }
   public double getSizeDetail() {
      return size;
   }
   public Color getColor() {
      return color;
   }
   public Shape getShape (){
      return shape;
   }

   public Double getMostRight() {
      return posX + size;
   }

   public Double getMostLeft() {
      return posX;
   }

   public Double getMostUp() {
      return posY;
   }

   public Double getMostDown() {
      return posY + size;
   }

   abstract Shape makeShape(double posX, double posY, double size);

}
