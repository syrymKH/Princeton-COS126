public class RGBtoCMYK {
    public static void main(String[] args) {
        // RGB r = red, g = green, b = blue
        double r = Double.parseDouble(args[0]);
        double g = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);

        // CMYK c = cyan, m = magenta, y = yellow, k = black
        // w = white

        double w = Math.max(r / 255, Math.max(g / 225, b / 255));
        double c = (w - r / 255) / w;
        double m = (w - g / 255) / w;
        double y = (w - b / 255) / w;
        double k = 1 - w;

        System.out.println("Red = " + (int) r);
        System.out.println("Green = " + (int) g);
        System.out.println("Blue = " + (int) b);
        System.out.println("Cyan = " + c);
        System.out.println("Magenta = " + m);
        System.out.println("Yellow = " + y);
        System.out.println("Black = " + k);
    }
}
