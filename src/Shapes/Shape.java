package Shapes;

import animation.Direction;
import animation.Motion;

public class Shape {
   float posX, posY;
   Motion motion;

   Shape (float posX, float posY) {
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
}
