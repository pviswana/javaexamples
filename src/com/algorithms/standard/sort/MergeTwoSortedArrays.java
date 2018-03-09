package com.algorithms.standard.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        new MergeTwoSortedArrays().execute();
    }

    private void execute() {
        List<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(13);
        A.add(17);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);

        List<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(7);
        B.add(11);
        B.add(19);

        List<Integer> merged = mergeTwoSortedArrays(A, 3, B, B.size());
        for (Integer value : merged) {
            System.out.println(value);
        }
    }

    private List<Integer> mergeTwoSortedArrays(List<Integer> A, int m,
                                               List<Integer> B, int n) {
        int a = m -1, b = n -1, idx = m + n - 1;

        while (a >= 0 && b >= 0) {
            A.set(idx--, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
        }

        while ( b >= 0) {
            A.set(idx--,B.get(b--) );
        }
        return A;
    }
}
