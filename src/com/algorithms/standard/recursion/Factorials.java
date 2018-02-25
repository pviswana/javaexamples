package com.algorithms.standard.recursion;

public class Factorials {
    public static void main(String[] args) {
        int factorial = new Factorials().computeFactorial(5);
        System.out.println(factorial);
    }

    private int computeFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * computeFactorial(n - 1);
        }
    }
}
