package com.algorithms.standard.dynamic;

import java.util.Arrays;

public class ComputeNumberOfWays {
    public static void main(String[] args) {
        ComputeNumberOfWays computeNumberOfWays = new ComputeNumberOfWays();
        computeNumberOfWays.execute();
    }

    public void execute() {
        int n = 4, m = 4;
        System.out.println(computeNumberOfWays(n, m));
        int[][] numberOfWays = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(numberOfWays[i], 0);
        }
        System.out.println(computeNumberOfWays(n, m, numberOfWays));
    }

    /** Recursive */
    private int computeNumberOfWays(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }

        int xValue = 0;
        int yValue = 0;

        if (x > 0)
            xValue = computeNumberOfWays(x -1, y);

        if (y > 0)
            yValue = computeNumberOfWays(x, y-1 );
        return xValue + yValue;
    }

    /** Dynamic */
    private int  computeNumberOfWays(int x, int y, int[][] numberOfWays) {
        if (x == 0 && y == 0) {
            return 1;
        }

        if (numberOfWays[x][y] == 0) {
            int waysLeft = x == 0 ? 0 : computeNumberOfWays(x - 1, y);
            int waysTop = y == 0 ? 0 : computeNumberOfWays(x, y - 1);
            numberOfWays[x][y] = waysLeft + waysTop;
        }
        return numberOfWays[x][y];
    }
}
