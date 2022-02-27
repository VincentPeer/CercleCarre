package animation;

public class Motion {
    Direction dir;
    float speed;

    public Motion(Direction dir, float speed) {
        this.dir = dir;
        this.speed = speed;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(double rad) {
        this.dir.setRadAngle(rad);
    }

}
