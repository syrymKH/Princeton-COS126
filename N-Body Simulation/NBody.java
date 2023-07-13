public class NBody {
    public static void main(String[] args) {
        double stoppingTime = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]); // ∆t

        int n = StdIn.readInt();
        double radius = StdIn.readDouble();

        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];

        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        StdDraw.enableDoubleBuffering();

        StdAudio.play("2001.wav");

        double g = 6.67 * Math.pow(10, -11); // gravitational constant G

        double[] ax = new double[n];
        double[] ay = new double[n];

        for (double t = 0.0; t < stoppingTime; t += dt) {

            double[] fx = new double[n];
            double[] fy = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double dx = px[j] - px[i]; // ∆x
                        double dy = py[j] - py[i]; // ∆y
                        double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                        double f = g * mass[i] * mass[j] / Math.pow(r, 2);
                        fx[i] += f * dx / r;
                        fy[i] += f * dy / r;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                ax[i] = fx[i] / mass[i];
                ay[i] = fy[i] / mass[i];
                vx[i] += ax[i] * dt;
                vy[i] += ay[i] * dt;
                px[i] += vx[i] * dt;
                py[i] += vy[i] * dt;
            }

            StdDraw.picture(0, 0, "Starfield.jpg");
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }

        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }
}
