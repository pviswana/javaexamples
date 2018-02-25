package com.algorithms.standard.recursion;

public class TriangularNumbers {
    public static void main(String[] args) {
        new TriangularNumbers().execute();
    }

    public void execute() {
        log(String.valueOf(triangleWithoutRecursion(5)));
        log(String.valueOf(triangleWithRecursion(5)));
    }

    private void log(String message) {
        System.out.println(message);
    }

    private int triangleWithoutRecursion(int n) {
        int total = 0;
        while (n > 0) {
            total += n;
            n--;
        }
        return total;
    }

    private int triangleWithRecursion(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + triangleWithRecursion(n - 1);
        }
    }
}
