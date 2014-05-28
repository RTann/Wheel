package physics;

/**
 * Basic Newtonian Mechanics functions to be used for Wheel simulation
 *
 * @author Ross Tannenbaum and Michael Francis
 */
public final class Mechanics {

    /* Acceleration due to gravity on Earth */
    private static final double G = 9.81;
    /* Impulse time */
    private static final double T = .1;
    /* Coefficient of Static Friction */
    private static final double MU = .004;

    private Mechanics() {
    }

    /**
     * Computes force exerted on Wheel (minimum force of 10 Newtons).
     *
     * @param start Start time
     * @param end End time
     * @return Force exerted on Wheel in Newtons
     */
    public static int getForce(long start, long end) {
        int force = (int) Math.ceil((end - start) / 10);
        return force <= 10 ? 10 : force;
    }

    /**
     * Computes Force of Static Friction exerted on Wheel by Ground
     *
     * @param mass mass of Wheel
     * @return Force of Static Friction on Wheel in Newtons
     */
    public static int getFriction(double mass) {
        return (int) Math.ceil(mass * G * MU);
    }

    /**
     * Computes Acceleration of Wheel
     *
     * @param force Force exerted on Wheel in Newtons
     * @param mass Mass of Wheel in kilograms
     * @return Acceleration in meters per squared second
     */
    public static double getAcceleration(int force, double mass) {
        return force / mass;
    }

    /**
     * Computes Velocity of Wheel
     *
     * @param force Force exerted on Wheel in Newtons
     * @param mass Mass of Wheel in kilograms
     * @return Velocity of Wheel in meters per second
     */
    public static double getVelocity(int force, double mass) {
        //Impulse = change in momentum
        return force * T / mass;
    }

    /**
     * Computes Velocity of Wheel
     *
     * @param initialVelocity Initial velocity of Wheel in meters per second
     * @param acceleration Acceleration of Wheel in meters per squared second
     * @param time Change in time in seconds
     * @return Velocity of Wheel in meters per second
     */
    public static double getVelocity(double initialVelocity,
            double acceleration, double time) {
        return initialVelocity + acceleration * time;
    }

    /**
     * Computes Position of Wheel
     *
     * @param initialPosition Initial position of Wheel in meters
     * @param currentVelocity Initial velocity of Wheel in meters per second
     * @param acceleration Acceleration of Wheel in meters per squared second
     * @param time Change in time in seconds
     * @return Position of Wheel in meters
     */
    public static int getPosition(int initialPosition, double currentVelocity,
            double acceleration, int time) {
        return (int) Math.ceil(initialPosition + currentVelocity * time
                + .5 * acceleration * Math.pow(time, 2));
    }

}
