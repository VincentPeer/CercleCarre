package bouncers.animation;

/**
 * Manage the motion for a piece
 * @authors De Bleser, Peer
 */
public class Motion {
    private Double radAngle;
    private float speed;

    /**
     * Constructor of the class representing a motion
     * @param radAngle direction of the motion
     * @param speed speed indication
     */
    public Motion(Double radAngle, float speed) {
        this.radAngle = radAngle;
        this.speed = speed;
    }

    /**
     * @return the direction of the motion in rad
     */
    public Double getDir() {
        return radAngle;
    }

    /**
     * Set the direction of the motion in rad
     * @param rad direction in rad
     */
    public void setDir(double rad) {
        this.radAngle = rad;
    }

    /**
     * @return the speed of the motion
     */
    public float getSpeed() {
        return speed;
    }
}
