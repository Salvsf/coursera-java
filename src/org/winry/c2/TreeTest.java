package org.winry.c2;

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree("winry", 3);
        tree.update("test", 1);
        tree.update("test3", 2);
        tree.update("test5", 4);
        tree.update("test4", 23);
        tree.update("test3", 55);
        tree.update("test15", 42);

        int value = tree.lookup("test15");
        System.out.println(value);
    }
}
