package Shapes;

import animation.Direction;
import animation.Motion;
import java.awt.*;

abstract public class Shape extends Component {
   double posX, posY;
   Motion motion;


   Shape (double posX, double posY) {
      this.posX = posX;
      this.posY = posY;
   }

   public void bounce(Direction wallDir) {
      motion.setDir(Math.PI - wallDir.getRad() + 2 * wallDir.getRad());
   }

   public void move() {
      posX +=  Math.cos(motion.getDir().getRad());
      posY +=  Math.sin(motion.getDir().getRad());
   }

   abstract public boolean isInContact();

   abstract public void draw(Graphics g);
}
