package physics;

/**
 *
 * @author rosstannenbaum
 */
public class Mechanics {

    /* Acceleration due to gravity on Earth */
    private static final double G = 9.81;
    /* Impulse time */
    private static final double T = 1;

    /**
     * Computes force exerted onto Wheel (minimum force of 5 Newtons).
     *
     * @param start Start time
     * @param end End time
     * @return Force in Newtons
     */
    public static int getForce(long start, long end) {
        int force = (int) Math.ceil((end - start) / 100);
        return force <= 1 ? 1 : force;
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

    public static double getAcceleration(int force, double mass) {
        return force / mass;
    }

    public static double getVelocity(int force, double mass) {
        return force * T / mass;
    }

    public static double getVelocity(double initialVelocity,
            double acceleration, long time) {
        return initialVelocity + acceleration * time;
    }

    public static int getPosition(int initialPosition, double currentVelocity,
            double acceleration, long time) {
        return (int) (initialPosition + currentVelocity * time
                + .5 * acceleration * Math.pow(time, 2));
    }
}
