package mandelbrot;

/**
 * Some helpful functions and values.
 */
class Helpers {
    /**
     * A small double used to bound the precision of the comparison of doubles.
     */
    final static double EPSILON = 1e-9;

    /**
     * Comparison of doubles (up to <code>EPSILON</code>)
     * <p>
     * Please note that floating-point comparison is very tricky, this function
     * is not suited to compare small floating-point numbers.
     *
     * @param d1 an arbitrary double
     * @param d2 an arbitrary double
     * @return the result of comparing <code>d1</code> and <code>d2</code>.
     */
    static int doubleCompare(double d1, double d2) {
        double diff = d1 - d2;
        return
                (diff > EPSILON) ? 1 :
                        (diff < -EPSILON) ? -1 :
                                0;
    }
}
