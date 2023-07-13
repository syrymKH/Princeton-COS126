public class Art {

    public static void circle(double x, double y, double radius) {
        int randomColor = 1 + (int) (Math.random() * 2);

        if (randomColor > 1)
            StdDraw.setPenColor(StdDraw.BLUE);
        else
            StdDraw.setPenColor(StdDraw.GREEN);

        StdDraw.filledCircle(x, y, radius / 4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(x, y, radius / 4);
    }

    public static void draw(int n, double x, double y, double radius) {
        if (n == 0)
            return;
        else
            circle(x, y, radius);
        double r = radius / 2;
        
        draw(n - 1, x - r, y - r, r);
        draw(n - 1, x - r, y + r, r);
        draw(n - 1, x + r, y - r, r);
        draw(n - 1, x + r, y + r, r);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
