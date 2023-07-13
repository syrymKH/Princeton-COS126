public class RandomWalkers {
    public static void main(String[] args) {

        int steps = Integer.parseInt(args[0]);
        double[] trials = new double[Integer.parseInt(args[1])];

        for (int i = 0; i < trials.length; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < steps; j++) {
                double randomDirection = Math.random();
                if (0 < randomDirection && randomDirection < 0.25) {
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
            }
            trials[i] = ((x * x) + (y * y));
        }
        double sum = 0.0;
        for (int k = 0; k < trials.length; k++) {
            sum += trials[k];
        }
        double mean = sum / trials.length;
        System.out.println("mean squared distance = " + mean);
    }
}
