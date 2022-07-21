package org.winry.c2;

public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        Position position = new Position();
        System.out.println(position);
        int steps = 0;
        while (position.getDistance() < r) {
            position.walk();
            System.out.println(position);
            steps++;
        }
        System.out.println("steps = " + steps);
    }
}
