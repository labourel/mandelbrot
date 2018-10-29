package viewer;


import javafx.scene.paint.Color;

/**
 * A subpixel contributes to the color of one pixel. Pixels are usually
 * composed of several subpixels, whose colors are averaged.
 */

class SubPixel {

    private Color color = Color.BLACK;

    /**
     * Each subpixel has a value that will be used to color them.
     */
    final double value;


    /**
     * Creates a subpixel.
     *
     * @param value divergence for the corresponding pixel. This will be mapped to a color.
     */
    SubPixel(double value) {
        this.value = value;
    }

    /**
     * Attributes a color to a subpixel.
     *
     * @param color the color to give to the subpixel
     */
    void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the color of the subpixel. Default is black.
     */
    Color getColor() {
        return color;
    }

    /**
     * Comparison of two subpixels by their values.
     *
     * @param pix1 first subpixel to compare
     * @param pix2 second subpixel to compare
     * @return an integer representing the result of the comparison, with the usual convention.
     */
    static int compare(SubPixel pix1, SubPixel pix2) {
        return Double.compare(pix1.value, pix2.value);
    }
}
