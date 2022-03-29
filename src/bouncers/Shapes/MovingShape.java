package bouncers.Shapes;

import bouncers.Displayer;
import bouncers.animation.Motion;
import utils.Renderer;

import java.awt.*;
import java.util.Random;

abstract public class MovingShape implements Bounceable {
   private final Color color;
   private final Renderer renderer;
   private final Displayer display;
   private static final Random rand = new Random();
   private final Motion motion;
   double x, y, size;


   public MovingShape(Color color, Renderer renderer, Displayer display) {
      this.color = color;
      this.renderer = renderer;
      this.display = display;
      // Random speed and direction
      motion = new Motion(rand.nextDouble() * 2 * Math.PI, rand.nextFloat());
      x = display.getWidth() / 2.;
      y = display.getHeight() / 2.;
      // Random size
      size = rand.nextInt(Math.min(display.getWidth(), display.getHeight()) / 15) + 4;
   }

   public void move() {
      // Check if should bounce before moving
      if (x <= 0 || x + size >= display.getWidth())
         bounce(Math.PI / 2);
      else if (y <= 0 || y + size >= display.getHeight())
         bounce(0.);
      // Updating position
      x += Math.cos(motion.getDir()) * motion.getSpeed();
      y -= Math.sin(motion.getDir()) * motion.getSpeed();
   }

   public void bounce(Double wallAngle) {
      // Calculating new direction
      double newDir = 2 * Math.PI - motion.getDir() + 2 * wallAngle;
      motion.setDir(newDir);
   }

   public void draw() {
      renderer.display(display.getGraphics(), this);
   }

   public Color getColor() {
      return color;
   }

   abstract public Shape getShape ();

}
