package com.algorithms.standard.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        double[] inputArray = new double[]{1, 2, 3, 4, 6, 7, 8};
        double findNumber = 8;
        BinarySearch binarySearch = new BinarySearch();
        int foundIndex = binarySearch.searchWithoutRecursion(inputArray, findNumber);
        System.out.println(foundIndex);
        foundIndex = binarySearch.searchWithRecursion(inputArray, findNumber);
        System.out.println(foundIndex);
    }

    private int searchWithoutRecursion(double[] inputArray, double findNumber) {
        int nElems = inputArray.length;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currIndex = 0;

        while(true) {
            currIndex = (upperBound + lowerBound) / 2;
            if (inputArray[currIndex] == findNumber) {
                return currIndex;
            } else if (lowerBound > upperBound){
                return -1;
            } else {
                if (inputArray[currIndex] < findNumber) {
                    lowerBound = currIndex + 1;
                } else {
                    upperBound = currIndex - 1;
                }
            }
        }
    }

    private int searchWithRecursion(double[] inputArray, double findNumber) {
        return recursiveSearch(inputArray, findNumber, 0, inputArray.length);
    }

    private int recursiveSearch(double[] inputArray, double findNumber, int lowerBound, int upperBound) {
        int currIndex = (lowerBound + upperBound) / 2;
        if (inputArray[currIndex] == findNumber) {
            return currIndex;
        } else if (lowerBound > upperBound) {
            return -1;
        } else {
            if (inputArray[currIndex] < findNumber) {
                return recursiveSearch(inputArray, findNumber, currIndex + 1, upperBound);
            } else {
                return recursiveSearch(inputArray, findNumber, lowerBound, currIndex - 1);
            }
        }
    }
}
