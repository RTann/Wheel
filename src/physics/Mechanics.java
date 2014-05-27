package physics;

/**
 *
 * @author rosstannenbaum
 */
public class Mechanics {
    
    /* Acceleration due to gravity on Earth */
    private static final double G = 9.81;
    
    /**
     * Computes force exerted onto Wheel
     * 
     * @param start Start time
     * @param end End time
     * @return Force in Newtons
     */
    public static int getForce(long start, long end) {
        return (int) Math.ceil((end - start) / 100);
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
