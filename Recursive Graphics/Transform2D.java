import java.awt.Color;

public class Transform2D {

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {

        for (int i = 0; i < x.length; i++) {
            x[i] = alpha * x[i];
            y[i] = alpha * y[i];
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {

        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {

        double[] arrayx = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayx[i] = array[i];
        }
        return arrayx;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {

        double radians = Math.toRadians(theta);
        double temp;
        for (int i = 0; i < x.length; i++) {
            temp = x[i];
            x[i] = x[i] * Math.cos(radians) - y[i] * Math.sin(radians);
            y[i] = y[i] * Math.cos(radians) + temp * Math.sin(radians);
        }
    }

    // Tests each of the API methods by directly calling them
    public static void main(String[] args) {

        StdDraw.setXscale(-5, +5);
        StdDraw.setYscale(-5, +5);

        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        StdDraw.setPenColor(Color.RED);
        StdDraw.polygon(x, y);

        // // copy
        // double[] cx = Transform2D.copy(x);
        // double[] cy = Transform2D.copy(y);
        //
        // // scale
        // scale(x, y, 2.0);
        // StdDraw.setPenColor(Color.BLUE);
        // StdDraw.polygon(x, y);
        //
        // // translate
        // translate(x, y, 2.0, 1.0);
        // StdDraw.setPenColor(Color.BLUE);
        // StdDraw.polygon(x, y);
        //
        // // rotate
        // rotate(x, y, 45.0);
        // StdDraw.setPenColor(Color.BLUE);
        // StdDraw.polygon(x, y);
    }
}
