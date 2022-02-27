package world.Shapes;

import world.animation.Direction;

public class Wall extends Shape{
    private double length;
    private Direction dir;

    public Wall(double posX, double posY, double length, Direction dir) {
        super(posX, posY);
        this.length = length;
        this.dir = dir;
    }

    public boolean isCollided(double posX, double posY) {
        // todo equation d'une droite avec rad (trouver si posx, posy est sur la droite)
        // todo just pour test
        return Math.abs(getAngle() ) < 0.01 && (posY <= 0 || posY >= 400) || Math.abs(getAngle() - Math.PI / 2) < 0.01 && (posX <= 0 || posX >= 400);
    }

    public Double getAngle() {
        return dir.getRad();
    }
}
