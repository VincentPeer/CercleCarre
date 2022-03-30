package bouncers.Shapes;

import bouncers.Displayer;
import bouncers.animation.Motion;
import utils.Renderer;

import java.awt.*;
import java.util.Random;

/**
 * Bases rules to make a new piece, pieces classes will extend this abstract class.
 * @authors De Bleser, Peer
 */
abstract public class MovingShape implements Bounceable {
   private final Color color;
   private final Renderer renderer;
   private final Displayer displayer;
   private static final Random rand = new Random();
   private final Motion motion;
   private double x, y, size;

   /**
    * Constructor to build a shape of random size, direction, speed and start position
    * @param color color of the shape
    * @param renderer renderer used to draw the square
    * @param displayer displayer on witch to draw the square on
    */
   public MovingShape(Color color, Renderer renderer, Displayer displayer) {
      this.color = color;
      this.renderer = renderer;
      this.displayer = displayer;
      // Random speed and direction
      motion = new Motion(rand.nextDouble() * 2 * Math.PI, rand.nextFloat());
      x = this.displayer.getWidth() / 2.;
      y = this.displayer.getHeight() / 2.;
      // Random size
      size = rand.nextInt(Math.min(this.displayer.getWidth(), this.displayer.getHeight()) / 15) + 4;
   }

   /**
    * Moves the shapes of 1 tick according to its direction and speed
    */
   public void move() {
      // Check for wall collision
      if (x <= 0 || x + size >= displayer.getWidth())
         bounce(Math.PI / 2);
      else if (y <= 0 || y + size >= displayer.getHeight())
         bounce(0.);
      // Updating position
      x += Math.cos(motion.getDir()) * motion.getSpeed();
      y -= Math.sin(motion.getDir()) * motion.getSpeed();
   }

   /**
    * Changes the direction of the shape according to th direction of a given wall
    * @param wallAngle Angle of the wall in radians
    */
   public void bounce(Double wallAngle) {
      // Calculating new direction
      double newDir = 2 * Math.PI - motion.getDir() + 2 * wallAngle;
      motion.setDir(newDir);
   }

   /**
    * Draw the shape using its renderer
    */
   public void draw() {
      renderer.display(displayer.getGraphics(), this);
   }

   /**
    * @return The color of the shapes
    */
   public Color getColor() {
      return color;
   }

   /**
    * @return x position of the shape
    */
   public double getX() {
      return x;
   }

   /**
    * @return y position of the shape
    */
   public double getY() {
      return y;
   }

   /**
    * @return the size of the shape
    */
   public double getSize() {
      return size;
   }

   /**
    * @return AWT Shape
    */
   abstract public Shape getShape ();

}
