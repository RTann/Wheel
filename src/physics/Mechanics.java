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
    public int getForce(long start, long end) {
        return (int) (end - start) / 100;
    }
    
    /**
     * Compute Force of Static Friction of Ground on Wheel
     * 
     * @param normal Normal force of Wheel on ground
     * @return Force of Static Friction
     */
    public int getFriction(long normal) {
        //TODO
        return 0;
    }
    
}
