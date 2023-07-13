public class Bits {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int counter = 0;

        if (n < 0)
            System.out.println("Illegal Input");
        else {
            while (n > 0) {
                n = n / 2;
                counter++;
            }
            System.out.println(counter);
        }
    }
}
