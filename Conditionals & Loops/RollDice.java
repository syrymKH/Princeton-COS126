public class RollDice {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        String[] array = new String[61];

        for (int i = 0; i < array.length; i++) {
            array[i] = " ";
        }

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int dice = (int) (Math.random() * 6) + 1;
                sum += dice;
            }
            array[sum] += "*";
        }
        for (int i = 10; i < array.length; i++) {
            System.out.println(i + " : " + array[i]);
        }
    }
}
