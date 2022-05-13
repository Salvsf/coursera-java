public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double a, b, c, d;
        a = Math.sin((x2 - x1) / 2.0);
        b = Math.cos(x1) * Math.cos(x2);
        c = Math.sin((y2 - y1) / 2.0);
        d = 2.0 * 6371.0 * Math.asin(Math.pow((a * a + b * c * c), 0.5));
        System.out.println(d + " kilometers");
    }
}
