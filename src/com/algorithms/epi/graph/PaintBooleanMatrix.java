package com.algorithms.epi.graph;

import java.util.List;

public class PaintBooleanMatrix {
    final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void flipcolor(List<List<Boolean>> A, int x, int y) {
        // save current color
        boolean color = A.get(x).get(y);

        // flip the current cell color
        A.get(x).set(y, !color);

        for (int[] dir : DIRS)  {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX <= A.size() && nextY >= 0 &&
                    nextY <= A.get(nextX).size() && A.get(nextX).get(nextY) == color ) {
                flipcolor(A,nextX ,nextY);
            }
        }

    }
}
