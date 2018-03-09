package com.algorithms.standard.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectTwoSortedArrays {
    public static void main(String[] args) {
        new IntersectTwoSortedArrays().execute();
    }

    private void execute() {
        List<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(5);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(12);

        List<Integer> B = new ArrayList<Integer>();
        B.add(5);
        B.add(5);
        B.add(6);
        B.add(8);
        B.add(8);
        B.add(9);
        B.add(10);
        B.add(10);
        B.add(7);
        B.add(8);
        B.add(12);

        List<Integer> merged = merge2Arrays(A, B);
        for (Integer value : merged) {
            System.out.println(value);
        }

        List<Integer> merged2 = merge2Arrays2(A, B);
        for (Integer value : merged2) {
            System.out.println(value);
        }

        List<Integer> merged3 = merge2Array3(A, B);
        for (Integer value : merged3) {
            System.out.println(value);
        }
    }

    /**
     * Time complexity = O(mn)
     * @param A
     * @param B
     * @return
     */
    private List<Integer> merge2Arrays(List<Integer> A, List<Integer> B) {
        List<Integer> mergedArray = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            if ((i == 0 || A.get(i - 1) != A.get(i)) && B.contains(A.get(i))) {
                mergedArray.add(A.get(i));
            }
        }

        return mergedArray;
    }

    /**
     * Time complexity = O(mlogn)
     * @param A
     * @param B
     * @return
     */
    private List<Integer> merge2Arrays2(List<Integer> A, List<Integer> B) {
        List<Integer> mergedArray = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            if ((i == 0 || A.get(i - 1) != A.get(i)) && Collections.binarySearch(B, A.get(i)) >= 0) {
                mergedArray.add(A.get(i));
            }
        }

        return mergedArray;
    }

    private List<Integer> merge2Array3(List<Integer> A, List<Integer> B) {
        List<Integer> merge = new ArrayList<Integer>();

        int i = 0, j = 0;
        while(i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j) && (i ==0 || A.get(i) != A.get(i - 1))) {
                merge.add(A.get(i));
                ++i;
                ++j;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return merge;
    }
}
