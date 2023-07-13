public class RandomWalker {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        int steps = Integer.parseInt(args[0]);

        for (int i = 0; i < steps; i++) {
            double randomDirection = Math.random();
            if (randomDirection < 0.25) {
                x++; // Direction to the east
            }
            else if (0.25 < randomDirection && randomDirection < 0.50) {
                y++; // Direction to the north
            }
            else if (0.50 < randomDirection && randomDirection < 0.75) {
                x--; // Direction to the west
            }
            else if (0.75 < randomDirection && randomDirection < 1.00) {
                y--; // Direction to the south
            }
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("squared distance = " + ((x * x) + (y * y)));
    }
}
