package animation;

public class Direction {
    private double x, y;
    double radAngle;

    public Direction(double radAngle) {
        this.radAngle = radAngle;
        this.x = Math.cos(radAngle);
        this.y = Math.sin(radAngle);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRad() {
        return radAngle;
    }

    public void setRadAngle(double radAngle) {
        this.radAngle = radAngle;
    }
}
