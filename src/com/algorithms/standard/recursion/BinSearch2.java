package com.algorithms.standard.recursion;

public class BinSearch2 {
    public static void main(String[] args) {
        int[] inputArray = new int[] {1, 2, 4, 7, 8};
        int findNumber = 1;
        new BinSearch2().binSearch(inputArray, findNumber);
    }

    public void binSearch(int[] inputArray, int findNumber) {
        int lowerBound = 0;
        int upperBound = inputArray.length;
        int index = binSearchRecursive(inputArray, findNumber, lowerBound, upperBound);
        System.out.println("Index: " + index);
    }

    private int binSearchRecursive(int[] inputArray, int findNumber, int lowerBound, int upperBound) {
        int currIndex = (lowerBound + upperBound) / 2;
        System.out.println("Entered lowerBound = " + lowerBound + "; upperBound: " + upperBound + "; currIndex: " + currIndex);

        if (lowerBound > upperBound) {
            currIndex = -1;
        } else if (inputArray[currIndex] == findNumber) {
            return currIndex;
        } else if (inputArray[currIndex] > findNumber) {
            currIndex = binSearchRecursive(inputArray, findNumber, lowerBound, currIndex - 1);
        } else {
            currIndex = binSearchRecursive(inputArray, findNumber, currIndex + 1, upperBound);
        }
        return currIndex;
    }
}
