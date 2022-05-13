public class RightTriangle {
    public static void main(String[] args) {
        long a = Integer.parseInt(args[0]);
        long b = Integer.parseInt(args[1]);
        long c = Integer.parseInt(args[2]);
        boolean arePositive;
        arePositive = (a > 0) && (b > 0) && (c > 0);
        boolean isRightTriangle = (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);

        System.out.print(arePositive && isRightTriangle);
    }
}
