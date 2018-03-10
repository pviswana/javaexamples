package com.algorithms.problems;

public class PhoneNumberCombinations {
    public static void main(String[] args) {
        new PhoneNumberCombinations().execute();
    }

    public void execute() {
        String[] phoneData = {"", "abc", "def", "ghi"};
        String inputString = "123";

        if (inputString == null || inputString.length() == 0) {
            print("");
        }

        int[] input = new int[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            input[i] = (inputString.charAt(i) - '0');
        }

        printAllLetterCombination(phoneData, input, 0, "");
    }

    private void printAllLetterCombination(String[] phoneData, int[] input, Integer inputIndex, String currOutput) {
        if (phoneData == null || phoneData.length == 0) {
            print("");
            return;
        }

        // validate the input index with the input string
        if (inputIndex == input.length) {
            print(currOutput);
            return;
        }

        int keyIndex = input[inputIndex];

        // The input string to be be processed
        String currData = phoneData[keyIndex];

        for (int i = 0; i < currData.length(); i++) {
            currOutput += currData.charAt(i);
            printAllLetterCombination(phoneData, input, inputIndex + 1,currOutput );
            currOutput = currOutput.substring(0, currOutput.length() -1);
        }
    }

    private void print(String data) {
        System.out.println(data);
    }
}
