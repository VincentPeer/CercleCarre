package world.Shapes;

import java.awt.*;

abstract public class Shape extends Component {
    double posX, posY;

    public Shape(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPos(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    abstract public boolean isCollided(double posX, double posY);

    abstract public Double getAngle();
}
