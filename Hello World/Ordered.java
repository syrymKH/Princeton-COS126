public class Ordered {
    public static void main(String[] args) {
        // Advanced Programming
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        int min = Math.min(x, Math.min(y, z));
        int max = Math.max(x, Math.max(y, z));
        int median = x + y + z - min - max;

        boolean isTrue = (x == min) && (y == median) && (z == max) ||
                (x == max) && (y == median) && (z == min);

        System.out.println(isTrue);
    }
}
