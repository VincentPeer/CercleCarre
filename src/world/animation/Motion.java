package world.animation;

public class Motion {
    Double radAngle;
    float speed;

    public Motion(Double radAngle, float speed) {
        this.radAngle = radAngle;
        this.speed = speed;
    }

    public Double getDir() {
        return radAngle;
    }

    public void setDir(double rad) {
        this.radAngle = rad;
    }

    public float getSpeed() {
        return speed;
    }
}
