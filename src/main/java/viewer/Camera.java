package viewer;

import mandelbrot.Complex;

/**
 * A class to represent the view (a rectangle over the complex plane)
 * to be displayed. Some interesting views are already defined.
 */
class Camera {

    /**
     * The high-level view of the Mandelbrot set.
     */
    static Camera camera0 =
            new Camera(
                    -0.5,
                    0.,
                    3,
                    4. / 3.);




    private Complex center; /* Center of the rectangle */
    private Complex width; /* Vector for the width of the rectangle */
    private Complex height; /* Vector for the height of the rectangle */


    /**
     * Creates a view.
     *
     * @param centerX     the real part of the point on which the view is centered
     * @param centerY     the imaginary part of the point on which the view is centered
     * @param width       the width of the rectangle to display
     * @param aspectRatio the ratio width/height of the rectangle to display
     */
    private Camera(double centerX, double centerY, double width, double aspectRatio) {
        this.width = Complex.real(width);
        this.height = new Complex(0, width / aspectRatio);
        this.center = new Complex(centerX, centerY);
    }

    /**
     * Converts position relative to the rectangle defining the view
     * into absolute complex numbers.
     *
     * @param tx horizontal relative position, between 0 (left) and 1 (right)
     * @param ty vertical relative position, between 0 (bottom) and 1 (top)
     * @return the complex at this position of the rectangle
     */
    Complex toComplex(double tx, double ty) {
        return center.add(width.scale(tx - 0.5)).add(height.scale(ty - 0.5));
    }

}
