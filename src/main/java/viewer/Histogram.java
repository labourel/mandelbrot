package viewer;

import javafx.scene.paint.Color;

/**
 * Histogram of colors, used to generate a list of colors made
 * from several gradients combined together, so that the list looks smooth.
 */
class Histogram {

    private double[] breakpoints;
    private Color[] colors;

    /**
     * Creates a schema of colors.
     * <code>breakpoints</code> and <code>colors</code> must have the same length.
     * Two consecutive indices of <code>colors</code> define a gradient of colors.
     * Those colors will be linearly mapped to the interval defined by the same
     * indices taken in <code>breakpoints</code>
     * For instance, { 0, 0.4, 1.} with { BLACK, RED, WHITE} represents a black
     * to red to white spectrum, where 40% of the point are the black to red
     * gradient, 60% are the red to white gradient.
     *
     * @param breakpoints values from 0 to 1, in increasing order, the first value must be 0 and the last one.
     * @param colors      colors assigned to each breakpoint.
     */
    Histogram(double[] breakpoints, Color[] colors) {
        assert (breakpoints[0] == 0);
        assert (breakpoints[breakpoints.length - 1] == 1);
        assert (colors.length == breakpoints.length);
        this.breakpoints = breakpoints;
        this.colors = colors;
    }


    /**
     * Generates a list of colors of given length representing this spectrum.
     *
     * @param howManyPoints the number of colors returned
     * @return a list of colors following the schema defined in the constructor
     */
    Color[] generate(int howManyPoints) {
        Color[] result = new Color[howManyPoints];
        double length = (double) howManyPoints;
        int bpIndex = 0;
        for (int ptIndex = 0; ptIndex < howManyPoints; ptIndex++) {
            double absolute = (double) ptIndex / length;
            while (absolute > breakpoints[bpIndex + 1] && bpIndex < breakpoints.length - 1)
                bpIndex++;
            double relative = (absolute - breakpoints[bpIndex]) / (breakpoints[bpIndex + 1] - breakpoints[bpIndex]);
            result[ptIndex] = colors[bpIndex].interpolate(colors[bpIndex + 1], relative);
        }
        return result;
    }

}
