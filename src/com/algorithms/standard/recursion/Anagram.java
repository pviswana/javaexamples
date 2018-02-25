package com.algorithms.standard.recursion;

public class Anagram {
    static int size;

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        char[] charArray = {'C', 'A', 'T'};
        size = charArray.length;
        anagram.doAnagram(charArray, charArray.length);
    }

    private void doAnagram(char[] charArray, int newSize) {
        if (newSize == 1) return;

        for (int j = 0; j < newSize; j++) {
            doAnagram(charArray, newSize - 1);

            if (newSize == 2) {
                display(charArray);
            }
            rotate(charArray, newSize);
        }
    }

    public void rotate(char[] charArray, int newSize) {
        int j = 0;
        int position = size - newSize;
        char temp = charArray[position];

        for (j = position + 1; j < size; j++) {
            charArray[j - 1] = charArray[j];
        }
        charArray[j - 1] = temp;
    }

    public void display(char[] charArray) {
        for (int i = 0; i < size; i++) {
            System.out.print(charArray[i]);
        }

        System.out.println();
    }
}
