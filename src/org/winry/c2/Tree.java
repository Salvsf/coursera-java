package org.winry.c2;

public class Tree {

    private String key;
    private int value;
    private Tree left;
    private Tree right;

    public Tree(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int lookup(String key) {
        if (this.key.equals(key)) {
            return value;
        } else {
            if (key.compareTo(this.key) < 0) {
                return left == null ? 0 : left.lookup(key);
            } else {
                return right == null ? 0 : right.lookup(key);
            }
        }
    }

    public void update(String key, int value) {
        if (key.equals(this.key)) {
            this.value = value;
        } else {
            if (key.compareTo(this.key) < 0) {
                if (left == null) {
                    left = new Tree(key, value);
                } else {
                    left.update(key, value);
                }
            } else {
                if (right == null) {
                    right = new Tree(key, value);
                } else {
                    right.update(key, value);
                }
            }
        }
    }

}
