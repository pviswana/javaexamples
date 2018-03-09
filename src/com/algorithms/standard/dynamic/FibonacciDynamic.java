package com.algorithms.standard.dynamic;

public class FibonacciDynamic {
    public static void main(String[] args) {
        FibonacciDynamic fibonacciDynamic = new FibonacciDynamic();
        System.out.println(fibonacciDynamic.fib_bottoms_up(5));
        System.out.println(fibonacciDynamic.rec_fib(5));
        int[] mem = new int[10];
        System.out.println(fibonacciDynamic.rec_fib(5, mem));
    }

    public int fib_bottoms_up(int n) {
        int[] bottoms_up = new int[n+1];
        if (n >= 1) {
            bottoms_up[1] = 1;
        }
        if (n >= 2) {
            bottoms_up[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            bottoms_up[i] = bottoms_up[i-1] + bottoms_up[i-2];
        }
        return bottoms_up[n];
    }

    public int rec_fib(int n) {
        if (n == 1 || n == 2) return 1;
        return rec_fib(n - 1) + rec_fib(n - 2);
    }

    public int rec_fib(int n, int[] mem) {
        int result = 0;

        if (n == 0) {
            return 0;
        }
        if (mem[n] != 0) {
            result = mem[n];
        } else if (n == 1) {
            mem[1] = 1;
            result = mem[1];
        } else if (n == 2) {
            mem[2] = 1;
            result = mem[2];
        } else {
            result = rec_fib(n - 1, mem) + rec_fib(n - 2, mem);
            mem[n] = result;
        }

        return result;
    }
}
