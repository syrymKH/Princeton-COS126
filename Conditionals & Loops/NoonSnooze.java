public class NoonSnooze {
    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        int minutes = snooze % 60;
        int hours = snooze / 60 + 12;

        String ampm;

        if ((hours % 24) < 12)
            ampm = "am";
        else
            ampm = "pm";

        hours = hours % 12;
        if (hours == 0) hours = 12;

        if (minutes < 10)
            System.out.println(hours + " : " + "0" + minutes + " " + ampm);
        else
            System.out.println(hours + " : " + minutes + " " + ampm);
    }
}
