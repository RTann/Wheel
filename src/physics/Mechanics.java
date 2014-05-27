package physics;

/**
 *
 * @author rosstannenbaum
 */
public class Mechanics {

    /* Acceleration due to gravity on Earth */
    private static final double G = 9.81;

    /**
     * Computes force exerted onto Wheel (minimum force of 5 Newtons).
     *
     * @param start Start time
     * @param end End time
     * @return Force in Newtons
     */
    public static int getForce(long start, long end) {
        int force = (int) Math.ceil((end - start) / 100);
        return force <= 0 ? 5 : force;
    }

    /**
     * Compute Force of Static Friction of Ground on Wheel
     *
     * @param normal Normal force of Wheel on ground
     * @return Force of Static Friction
     */
    public static int getFriction(long normal) {
        //TODO
        return 0;
    }

}
