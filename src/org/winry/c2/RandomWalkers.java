package org.winry.c2;

public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sum = 0;
        for (int i = 0; i < trials; i++) {
            sum += getSteps(r);
        }
        double average = (double) sum / trials;
        System.out.println("average number of steps = " + average);
    }

    public static int getSteps(int distance) {
        Position position = new Position();
        int steps = 0;
        while (position.getDistance() < distance) {
            position.walk();
            steps++;
        }
        return steps;
    }
}
