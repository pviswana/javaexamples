package com.algorithms.standard.sort;

import java.util.Collections;
import java.util.List;

public class SmallestNonConstructibleValue {
    public int smallestNonConstructibleValue(List<Integer> A) {
        int maxConstrValue = 0;
        Collections.sort(A);
        for (int a : A) {
            if (a > maxConstrValue + 1) {
                break;
            }
            maxConstrValue += a;
        }
        return maxConstrValue + 1;
    }
}
