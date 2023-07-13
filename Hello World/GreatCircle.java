public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double sin = Math.sin(x1) * Math.sin(x2);
        double cos = Math.cos(x1) * Math.cos(x2);
        double distance = 60 * Math.acos(sin + cos * Math.cos(y1 - y2));

        double distanceInDegrees = Math.toDegrees(distance);

        System.out.println(distanceInDegrees + " nautical miles");
    }
}
