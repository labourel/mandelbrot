package viewer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Collection;

/**
 * A Pixel. Because of antialiasing, each pixel is further decomposed into
 * subpixels. Each subpixels has a color, the color of the pixel is the average
 * of the subpixels' colors.
 */
class Pixel {

    private final int x;
    private final int y;
    private final Collection<SubPixel> subPixels;

    /**
     * Creates a pixel with given coordinates and subpixels.
     *
     * @param x         the horizontal coordinate of the pixel on the screen
     * @param y         the vertical coordinate of the pixel on the screen
     * @param subPixels a collection of subpixels for this pixel
     */
    Pixel(int x, int y, Collection<SubPixel> subPixels) {
        this.x = x;
        this.y = y;
        this.subPixels = subPixels;
    }


    /**
     * @return the list of subpixels in this pixel
     */
    Collection<SubPixel> getSubPixels() {
        return subPixels;
    }


    private Color getAverageColor() {
        double red = 0;
        double green = 0;
        double blue = 0;
        int count = 0;
        for (SubPixel subPixel : subPixels) {
            count++;
            Color col = subPixel.getColor();
            red += col.getRed();
            green += col.getGreen();
            blue += col.getBlue();
        }
        double c = (double) count;
        return new Color(red / c, green / c, blue / c, 1.);
    }


    /**
     * Displays the pixel.
     *
     * @param context the context of the canvas on which to paint.
     */
    void render(GraphicsContext context) {
        context.setFill(getAverageColor());
        context.fillRect((double) x, (double) y, 1, 1);
    }


}
