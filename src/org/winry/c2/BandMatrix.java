package org.winry.c2;

public class BandMatrix {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int p = j < i ? i - j : j - i;
                if (p <= width) {
                    System.out.print("*");
                } else {
                    System.out.print("0");
                }
                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
