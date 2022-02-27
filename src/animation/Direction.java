package animation;

public class Direction {
    private int x, y;
    double radAngle;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRad() {
        return radAngle;
    }

    public void setRadAngle(double radAngle) {
        this.radAngle = radAngle;
    }
}
