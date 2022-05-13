

public class CMYKtoRGB {
    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);
        int w, r, g, b;
        w = (int) (1 - k);
        r = (int) Math.round(255 * w * (1 - c));
        g = (int) Math.round(255 * w * (1 - m));
        b = (int) Math.round(255 * w * (1 - y));
        System.out.println("red   = " + r);
        System.out.println("green = " + g);
        System.out.println("blue  = " + b);

    }
}
