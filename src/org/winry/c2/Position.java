package org.winry.c2;

public class Position {

    private int x;
    private int y;

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public void walk() {
        boolean moveX = Math.random() < 0.5;
        boolean moveUp = Math.random() < 0.5;
        if (moveX) {
            if (moveUp) {
                x++;
            } else {
                x--;
            }
        } else {
            if (moveUp) {
                y++;
            } else {
                y--;
            }
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        boolean result = "#2224322".matches("#[\\d|a-f]{6}");
        System.out.println(result);
    }
}
