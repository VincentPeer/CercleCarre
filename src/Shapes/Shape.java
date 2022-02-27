package Shapes;

import animation.Direction;
import animation.Motion;
import java.awt.*;

abstract public class Shape extends Component {
   double posX, posY;
   Motion motion;
   static boolean bounced = false; // todo remove


   Shape (double posX, double posY, Motion motion) {
      this.posX = posX;
      this.posY = posY;
      this.motion = motion;
   }

   public void bounce(Direction wallDir) {
      //if (!bounced) {
         bounced = true;
         System.out.println("bounce");
         double newDir = 2 * Math.PI - motion.getDir().getRad() + 2 * wallDir.getRad();
         motion.setDir(newDir);
      //}

   }

   public void move() {
      Double wallDirection = isInContact();
      if (wallDirection != null)
         bounce(new Direction(wallDirection));
      posX -=  Math.cos(motion.getDir().getRad()) * motion.getSpeed();
      posY -=  Math.sin(motion.getDir().getRad()) * motion.getSpeed();
   }

   abstract public Double isInContact();

   abstract public void draw(Graphics g);
}
